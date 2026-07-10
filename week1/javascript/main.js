class EventClass {
    constructor({ id, name, category, date, seats, fee }) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.date = date;
        this.seats = seats;
        this.fee = fee;
        this.registeredUsers = [];
    }

    checkAvailability() {
        return this.seats - this.registeredUsers.length > 0;
    }

    register(user) {
        if (!this.checkAvailability()) {
            throw new Error(`No available seats for ${this.name}`);
        }
        this.registeredUsers.push(user);
    }

    cancel(user) {
        const index = this.registeredUsers.indexOf(user);
        if (index > -1) {
            this.registeredUsers.splice(index, 1);
        }
    }
}

let events = [];
const tracker = makeCategoryTracker();

function makeCategoryTracker() {
    const counts = {};
    return function(category) {
        counts[category] = (counts[category] || 0) + 1;
        return counts[category];
    };
}

window.addEventListener('load', () => {
    console.log("Welcome to the Community Portal");
    alert("Welcome to the Community Portal");
    loadEvents();
});

async function loadEvents() {
    const spinner = document.getElementById('loadingSpinner');
    spinner.style.display = 'block';
    try {
        const response = await fetch('events.json');
        if (!response.ok) throw new Error('Failed to fetch events');
        const rawData = await response.json();
        events = rawData.map(item => new EventClass(item));
        renderEvents(events);
    } catch (error) {
        console.error(error);
        document.getElementById('eventsList').innerHTML = `<p style="color: red;">Error loading events</p>`;
    } finally {
        spinner.style.display = 'none';
    }
}

function renderEvents(eventsList) {
    const container = document.getElementById('eventsList');
    container.innerHTML = '';
    
    eventsList.forEach(ev => {
        const card = document.createElement('div');
        card.className = 'event-card';
        
        const details = Object.entries(ev).map(([key, val]) => {
            if (key === 'registeredUsers') return '';
            return `<p><strong>${key}:</strong> ${val}</p>`;
        }).join('');

        const availableSeats = ev.seats - ev.registeredUsers.length;
        
        card.innerHTML = `
            <h3>${ev.name}</h3>
            ${details}
            <p><strong>Available Seats:</strong> <span id="seats-${ev.id}">${availableSeats}</span></p>
            <button onclick="registerForEvent(${ev.id})">Register</button>
            <button onclick="cancelRegistration(${ev.id})">Cancel</button>
        `;
        container.appendChild(card);
    });
}

function registerForEvent(eventId) {
    const ev = events.find(e => e.id === eventId);
    if (!ev) return;
    
    const userName = prompt("Enter your name to register:");
    if (!userName) return;

    try {
        ev.register(userName);
        tracker(ev.category);
        updateEventUI(ev);
        alert(`Registered successfully for ${ev.name}! Total registrations in ${ev.category}: ${ev.registeredUsers.length}`);
    } catch (err) {
        alert(err.message);
    }
}

function cancelRegistration(eventId) {
    const ev = events.find(e => e.id === eventId);
    if (!ev) return;

    const userName = prompt("Enter your name to cancel registration:");
    if (!userName) return;

    ev.cancel(userName);
    updateEventUI(ev);
    alert(`Cancelled registration for ${userName}`);
}

function updateEventUI(ev) {
    const seatsSpan = document.getElementById(`seats-${ev.id}`);
    if (seatsSpan) {
        seatsSpan.textContent = ev.seats - ev.registeredUsers.length;
    }
}

function filterEvents() {
    const searchVal = document.getElementById('searchInput').value.toLowerCase();
    const catVal = document.getElementById('categorySelect').value;
    
    const filtered = events.filter(ev => {
        const matchesSearch = ev.name.toLowerCase().includes(searchVal);
        const matchesCat = catVal === '' || ev.category === catVal;
        return matchesSearch && matchesCat;
    });
    
    renderEvents(filtered);
}

document.getElementById('searchInput').addEventListener('keydown', () => {
    setTimeout(filterEvents, 10);
});

document.getElementById('categorySelect').addEventListener('change', filterEvents);

async function submitForm(event) {
    event.preventDefault();
    const form = document.getElementById('registrationForm');
    const name = form.elements['name'].value;
    const email = form.elements['email'].value;
    const phone = form.elements['phone'].value;
    const eventId = form.elements['formEvent'].value;
    
    let valid = true;
    
    if (!/^\d{10}$/.test(phone)) {
        document.getElementById('phoneError').textContent = 'Phone number must be exactly 10 digits';
        valid = false;
    } else {
        document.getElementById('phoneError').textContent = '';
    }

    if (!valid) return;

    const payload = { name, email, phone, eventId };

    try {
        const response = await fetch('https://jsonplaceholder.typicode.com/posts', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(payload)
        });
        if (!response.ok) throw new Error('Form submission failed');
        const data = await response.json();
        document.getElementById('formOutput').innerHTML = `<p style="color: green;">Successfully registered! ID: ${data.id}</p>`;
        form.reset();
    } catch (err) {
        document.getElementById('formOutput').innerHTML = `<p style="color: red;">${err.message}</p>`;
    }
}

document.getElementById('registrationForm').addEventListener('submit', submitForm);
