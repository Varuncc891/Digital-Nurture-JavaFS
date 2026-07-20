import React, { Component } from 'react';

// Getuser class component (HOL 17 requirement)
export class Getuser extends Component {
  constructor(props) {
    super(props);
    this.state = {
      loading: true,
      person: null,
      error: null
    };
    this.fetchUser = this.fetchUser.bind(this);
  }

  fetchUser() {
    this.setState({ loading: true, error: null });
    fetch('https://randomuser.me/api/')
      .then((res) => {
        if (!res.ok) throw new Error("API call failed");
        return res.json();
      })
      .then((data) => {
        this.setState({
          person: data.results[0],
          loading: false
        });
      })
      .catch((err) => {
        this.setState({
          error: err.message,
          loading: false
        });
      });
  }

  componentDidMount() {
    this.fetchUser();
  }

  render() {
    const { loading, person, error } = this.state;

    if (loading) {
      return (
        <div style={{ display: 'flex', flexDirection: 'column', alignItems: 'center', padding: '2rem' }}>
          <div className="spinner"></div>
          <p style={{ marginTop: '1rem', color: 'var(--text-secondary)' }}>Loading user profiles...</p>
        </div>
      );
    }

    if (error) {
      return (
        <div style={{ color: '#ef4444', textAlign: 'center', padding: '2rem' }}>
          <p>Error loading user profiles: {error}</p>
          <button className="btn btn-secondary" style={{ marginTop: '1rem' }} onClick={this.fetchUser}>Retry Fetch</button>
        </div>
      );
    }

    if (!person) return null;

    const { title, first, last } = person.name;
    const fullName = `${title} ${first} ${last}`;
    const { email } = person;
    const avatar = person.picture.large;

    return (
      <div className="user-card glass" style={{ background: 'var(--bg-secondary)', border: 'none' }}>
        <img className="user-avatar" src={avatar} alt={fullName} />
        <h4 className="user-name">{fullName}</h4>
        <p className="user-email">{email}</p>
        <button className="btn btn-secondary" onClick={this.fetchUser}>Fetch Another User</button>
      </div>
    );
  }
}

const ApiFetcher = () => {
  return (
    <div className="card glass">
      <div className="page-header">
        <h2 className="page-title">REST API Consumption</h2>
        <p className="page-subtitle">Demonstrates fetch API, async lifecycle fetching, and dynamic loading views (concept 17).</p>
      </div>
      <div style={{ marginTop: '1.5rem', display: 'flex', justifyContent: 'center' }}>
        <Getuser />
      </div>
    </div>
  );
};

export default ApiFetcher;
