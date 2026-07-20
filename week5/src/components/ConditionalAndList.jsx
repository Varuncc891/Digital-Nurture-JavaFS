import React, { useState } from 'react';

export const ConditionalAndList = () => {
  const [isLoggedIn, setIsLoggedIn] = useState(false);
  const [bookingMessage, setBookingMessage] = useState("");

  const flights = [
    { id: "F101", airline: "Delta Air", origin: "New York (JFK)", destination: "London (LHR)", price: "$550" },
    { id: "F102", airline: "Lufthansa", origin: "Frankfurt (FRA)", destination: "Tokyo (NRT)", price: "$980" },
    { id: "F103", airline: "Singapore Air", origin: "Singapore (SIN)", destination: "Sydney (SYD)", price: "$720" },
    { id: "F104", airline: "Emirates", origin: "Dubai (DXB)", destination: "Paris (CDG)", price: "$650" }
  ];

  const handleBooking = (flightId) => {
    setBookingMessage(`Ticket for Flight ${flightId} booked successfully!`);
    setTimeout(() => setBookingMessage(""), 4000);
  };

  return (
    <div className="card glass">
      <div className="page-header" style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center' }}>
        <div>
          <h2 className="page-title">Flight search & booking</h2>
          <p className="page-subtitle">Demonstrates lists, keys, and conditional user rendering (concepts 12 & 13).</p>
        </div>
        <button 
          className={`btn ${isLoggedIn ? 'btn-secondary' : 'btn-primary'}`} 
          onClick={() => setIsLoggedIn(!isLoggedIn)}
        >
          {isLoggedIn ? 'Log Out' : 'Log In'}
        </button>
      </div>

      {bookingMessage && (
        <div style={{ padding: '1rem', backgroundColor: '#d1fae5', color: '#065f46', borderRadius: '8px', marginBottom: '1.5rem', fontWeight: 600 }}>
          {bookingMessage}
        </div>
      )}

      <div style={{ margin: '1.5rem 0', padding: '1rem', backgroundColor: 'var(--bg-primary)', borderRadius: '8px', fontSize: '0.875rem' }}>
        <p><strong>Current User Mode:</strong> {isLoggedIn ? 'Authenticated User (Booking Enabled)' : 'Guest User (View Only)'}</p>
      </div>

      <div className="list-container">
        <table className="list-table">
          <thead>
            <tr>
              <th>Flight Code</th>
              <th>Airline</th>
              <th>Origin</th>
              <th>Destination</th>
              <th>Price</th>
              <th>Action</th>
            </tr>
          </thead>
          <tbody>
            {flights.map((flight) => (
              <tr key={flight.id}>
                <td style={{ fontWeight: 'bold' }}>{flight.id}</td>
                <td>{flight.airline}</td>
                <td>{flight.origin}</td>
                <td>{flight.destination}</td>
                <td style={{ color: 'var(--accent)', fontWeight: 600 }}>{flight.price}</td>
                <td>
                  {isLoggedIn ? (
                    <button className="btn btn-primary" style={{ padding: '0.4rem 1rem', fontSize: '0.875rem' }} onClick={() => handleBooking(flight.id)}>
                      Book Ticket
                    </button>
                  ) : (
                    <span style={{ fontSize: '0.875rem', color: 'var(--text-secondary)', fontStyle: 'italic' }}>
                      Login to book
                    </span>
                  )}
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
};

export default ConditionalAndList;
