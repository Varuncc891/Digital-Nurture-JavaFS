import React, { Component } from 'react';

export class LifecycleClock extends Component {
  constructor(props) {
    super(props);
    this.state = {
      time: new Date(),
      status: "Component Initialized (Constructor)"
    };
    this.timerId = null;
  }

  componentDidMount() {
    this.setState({ status: "Component Mounted (componentDidMount)" });
    this.timerId = setInterval(() => {
      this.setState({ time: new Date() });
    }, 1000);
  }

  componentWillUnmount() {
    clearInterval(this.timerId);
    console.log("Component Will Unmount: Timer Cleared");
  }

  render() {
    return (
      <div className="card glass">
        <div className="page-header">
          <h2 className="page-title">Lifecycle Clock</h2>
          <p className="page-subtitle">Demonstrates component constructor, mounting, state updates, and unmounting teardown.</p>
        </div>
        
        <div className="clock-container glass" style={{ marginTop: '1.5rem', background: 'var(--bg-secondary)' }}>
          <div className="clock-display">
            {this.state.time.toLocaleTimeString()}
          </div>
          <div className="clock-date">
            {this.state.time.toLocaleDateString(undefined, { weekday: 'long', year: 'numeric', month: 'long', day: 'numeric' })}
          </div>
          <p style={{ marginTop: '1rem', color: '#10b981', fontWeight: 600 }}>
            {this.state.status}
          </p>
        </div>
      </div>
    );
  }
}

export default LifecycleClock;
