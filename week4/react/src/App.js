import React, { useState, useEffect, createContext, useContext } from 'react';

const ThemeContext = createContext('dark');

class ClassComponent extends React.Component {
    render() {
        return (
            <div style={{ padding: '10px', background: '#1e293b', borderRadius: '6px' }}>
                <h4>Class Component</h4>
                <p>Welcome to the first class component session.</p>
            </div>
        );
    }
}

class LifeCycleComponent extends React.Component {
    constructor(props) {
        super(props);
        this.state = { data: 'Loading...' };
    }
    componentDidMount() {
        setTimeout(() => {
            this.setState({ data: 'Data loaded successfully via componentDidMount!' });
        }, 1000);
    }
    render() {
        return (
            <div style={{ padding: '10px', background: '#1e293b', borderRadius: '6px', marginTop: '10px' }}>
                <h4>Lifecycle Demo</h4>
                <p>{this.state.data}</p>
            </div>
        );
    }
}

class OnlineShopping extends React.Component {
    constructor(props) {
        super(props);
        this.state = { cart: [] };
    }
    addToCart(item) {
        this.setState({ cart: [...this.state.cart, item] });
    }
    render() {
        const items = ['Laptop', 'Smartphone', 'Headphones'];
        return (
            <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr', gap: '20px' }}>
                <div>
                    <h5>Items List</h5>
                    {items.map(item => (
                        <div key={item} style={{ margin: '10px 0' }}>
                            <span>{item} </span>
                            <button onClick={() => this.addToCart(item)}>Add to Cart</button>
                        </div>
                    ))}
                </div>
                <div>
                    <h5>Cart Content</h5>
                    <ul>
                        {this.state.cart.map((item, idx) => <li key={idx}>{item}</li>)}
                    </ul>
                </div>
            </div>
        );
    }
}

function FunctionComponent() {
    return (
        <div style={{ padding: '10px', background: '#1e293b', borderRadius: '6px' }}>
            <h4>Functional Component</h4>
            <p>Welcome to the first functional component session.</p>
        </div>
    );
}

function DestructureDemo({ title, content }) {
    return (
        <div>
            <h5>Title: {title}</h5>
            <p>Content: {content}</p>
        </div>
    );
}

export default function App() {
    const [activeTab, setActiveTab] = useState('hol1');
    const [peopleCount, setPeopleCount] = useState(0);
    const [isLoggedIn, setIsLoggedIn] = useState(false);
    const [formData, setFormData] = useState({ name: '', email: '', password: '' });
    const [formErrors, setFormErrors] = useState({});
    const [randomUser, setRandomUser] = useState(null);
    const [openaiData, setOpenaiData] = useState([]);

    const handleFormChange = (e) => {
        const { name, value } = e.target;
        setFormData({ ...formData, [name]: value });
    };

    const validateForm = (e) => {
        e.preventDefault();
        const errors = {};
        if (!formData.name) errors.name = 'Name is required';
        if (!formData.email.includes('@')) errors.email = 'Valid email is required';
        if (formData.password.length < 6) errors.password = 'Password must be at least 6 characters';
        setFormErrors(errors);
        if (Object.keys(errors).length === 0) {
            alert('Form submitted successfully!');
        }
    };

    useEffect(() => {
        if (activeTab === 'hol17') {
            fetch('https://randomuser.me/api/')
                .then(res => res.json())
                .then(data => setRandomUser(data.results[0]))
                .catch(err => console.error(err));
        }
        if (activeTab === 'hol19') {
            setOpenaiData([
                { id: 1, name: 'GPT-4o', description: 'Multimodal model for text and image' },
                { id: 2, name: 'DALL-E 3', description: 'State of the art image generation model' },
                { id: 3, name: 'Whisper', description: 'Speech-to-text conversion model' }
            ]);
        }
    }, [activeTab]);

    return (
        <div style={{ maxWidth: '1000px', margin: '30px auto', padding: '20px', background: '#1e293b', borderRadius: '12px' }}>
            <h1 style={{ textAlign: 'center', background: 'linear-gradient(to right, #818cf8, #f472b6)', WebkitBackgroundClip: 'text', WebkitTextFillColor: 'transparent' }}>React Hands-On Labs Dashboard</h1>
            
            <nav style={{ display: 'flex', flexWrap: 'wrap', gap: '10px', margin: '20px 0', borderBottom: '1px solid #475569', paddingBottom: '15px' }}>
                <button onClick={() => setActiveTab('hol1')}>HOL 1-4 (Basic)</button>
                <button onClick={() => setActiveTab('hol5')}>HOL 5 (Dashboard)</button>
                <button onClick={() => setActiveTab('hol7')}>HOL 7 (Shopping)</button>
                <button onClick={() => setActiveTab('hol8')}>HOL 8 (Counter)</button>
                <button onClick={() => setActiveTab('hol10')}>HOL 10 (Office)</button>
                <button onClick={() => setActiveTab('hol11')}>HOL 11-13 (Events & Render)</button>
                <button onClick={() => setActiveTab('hol14')}>HOL 14 (Context)</button>
                <button onClick={() => setActiveTab('hol15')}>HOL 15-16 (Forms)</button>
                <button onClick={() => setActiveTab('hol17')}>HOL 17 (Random User)</button>
                <button onClick={() => setActiveTab('hol19')}>HOL 19 (OpenAI)</button>
            </nav>

            <div style={{ background: '#0f172a', padding: '20px', borderRadius: '8px', minHeight: '300px' }}>
                {activeTab === 'hol1' && (
                    <div>
                        <h2>welcome to the first session of React</h2>
                        <ClassComponent />
                        <FunctionComponent />
                        <LifeCycleComponent />
                    </div>
                )}

                {activeTab === 'hol5' && (
                    <div>
                        <h3>Cognizant Cohort Dashboard</h3>
                        <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr', gap: '20px' }}>
                            <div>
                                <h5>Ongoing Cohorts</h5>
                                <ul>
                                    <li>Java Full Stack Engineering (FSE) - 45 Interns</li>
                                    <li>React Native Development - 30 Interns</li>
                                </ul>
                            </div>
                            <div>
                                <h5>Completed Cohorts</h5>
                                <ul>
                                    <li>Data Science Foundation - 50 Interns</li>
                                    <li>AWS Cloud Practitioners - 40 Interns</li>
                                </ul>
                            </div>
                        </div>
                    </div>
                )}

                {activeTab === 'hol7' && (
                    <div>
                        <h3>Shopping Application</h3>
                        <OnlineShopping />
                    </div>
                )}

                {activeTab === 'hol8' && (
                    <div style={{ textAlign: 'center' }}>
                        <h3>Counter Application</h3>
                        <p style={{ fontSize: '2rem' }}>Count: {peopleCount}</p>
                        <button onClick={() => setPeopleCount(peopleCount + 1)} style={{ marginRight: '10px' }}>Increment</button>
                        <button onClick={() => setPeopleCount(peopleCount - 1)}>Decrement</button>
                    </div>
                )}

                {activeTab === 'hol10' && (
                    <div>
                        <h3>Office Space Rental App</h3>
                        <ul>
                            <li>Co-Working Desk - San Francisco ($250/mo)</li>
                            <li>Private Office - New York ($800/mo)</li>
                            <li>Conference Hall - Chicago ($150/hr)</li>
                        </ul>
                    </div>
                )}

                {activeTab === 'hol11' && (
                    <div>
                        <h3>Event Handling and Conditional Rendering</h3>
                        <button onClick={() => setIsLoggedIn(!isLoggedIn)} style={{ marginBottom: '15px' }}>
                            {isLoggedIn ? 'Log Out' : 'Log In'}
                        </button>
                        {isLoggedIn ? <p>Welcome logged-in user!</p> : <p>Please log in to continue.</p>}
                        <DestructureDemo title="Destructured Props" content="This item content was destructured from parameter values." />
                    </div>
                )}

                {activeTab === 'hol14' && (
                    <div>
                        <h3>React Context API</h3>
                        <ThemeContext.Provider value="dark">
                            <ThemeConsumerComponent />
                        </ThemeContext.Provider>
                    </div>
                )}

                {activeTab === 'hol15' && (
                    <div>
                        <h3>Form and Validation</h3>
                        <form onSubmit={validateForm}>
                            <p>
                                <label>Name: </label>
                                <input type="text" name="name" value={formData.name} onChange={handleFormChange} />
                                {formErrors.name && <span style={{ color: 'red' }}> {formErrors.name}</span>}
                            </p>
                            <p>
                                <label>Email: </label>
                                <input type="email" name="email" value={formData.email} onChange={handleFormChange} />
                                {formErrors.email && <span style={{ color: 'red' }}> {formErrors.email}</span>}
                            </p>
                            <p>
                                <label>Password: </label>
                                <input type="password" name="password" value={formData.password} onChange={handleFormChange} />
                                {formErrors.password && <span style={{ color: 'red' }}> {formErrors.password}</span>}
                            </p>
                            <button type="submit">Submit</button>
                        </form>
                    </div>
                )}

                {activeTab === 'hol17' && (
                    <div>
                        <h3>Random User Details</h3>
                        {randomUser ? (
                            <div style={{ textAlign: 'center' }}>
                                <img src={randomUser.picture.large} alt="user" style={{ borderRadius: '50%' }} />
                                <h4>{randomUser.name.first} {randomUser.name.last}</h4>
                                <p>{randomUser.email}</p>
                            </div>
                        ) : <p>Loading user...</p>}
                    </div>
                )}

                {activeTab === 'hol19' && (
                    <div>
                        <h3>OpenAI Dashboard - Available Models</h3>
                        <ul>
                            {openaiData.map(m => (
                                <li key={m.id}>
                                    <strong>{m.name}:</strong> {m.description}
                                </li>
                            ))}
                        </ul>
                    </div>
                )}
            </div>
        </div>
    );
}

function ThemeConsumerComponent() {
    const theme = useContext(ThemeContext);
    return <p>Current theme from context: <strong>{theme}</strong></p>;
}
