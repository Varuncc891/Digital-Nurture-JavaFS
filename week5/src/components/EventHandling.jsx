import React, { Component } from 'react';

export class EventHandling extends Component {
  constructor(props) {
    super(props);
    this.state = {
      inputText: "",
      clickMessage: "No click events captured yet.",
      syntheticEventDetails: {}
    };
    // Explicit binding of 'this' (HOL 11 requirement)
    this.handleInputChange = this.handleInputChange.bind(this);
    this.handleButtonClick = this.handleButtonClick.bind(this);
  }

  handleInputChange(event) {
    this.setState({
      inputText: event.target.value
    });
  }

  handleButtonClick(event) {
    // Capturing details from React SyntheticEvent
    const eventDetails = {
      type: event.type,
      targetTagName: event.target.tagName,
      timestamp: event.timeStamp.toFixed(0)
    };

    this.setState({
      clickMessage: "Click captured successfully!",
      syntheticEventDetails: eventDetails
    });
  }

  render() {
    return (
      <div className="card glass">
        <div className="page-header">
          <h2 className="page-title">Event Handlers & Synthetic Events</h2>
          <p className="page-subtitle">Demonstrates explicitly bound handlers and React SyntheticEvent object details.</p>
        </div>

        <div style={{ display: 'flex', flexDirection: 'column', gap: '1.5rem', marginTop: '1.5rem' }}>
          
          <div className="form-group">
            <label className="form-label" htmlFor="text-input">Type something to test onChange handler:</label>
            <input 
              id="text-input"
              type="text" 
              className="form-input" 
              value={this.state.inputText} 
              onChange={this.handleInputChange}
              placeholder="Start typing..." 
            />
            {this.state.inputText && (
              <p style={{ marginTop: '0.5rem', color: 'var(--accent)', fontWeight: 500 }}>
                Live Echo: {this.state.inputText}
              </p>
            )}
          </div>

          <div style={{ borderTop: '1px solid var(--border)', paddingTop: '1.5rem' }}>
            <button className="btn btn-primary" onClick={this.handleButtonClick}>
              Trigger Click Event
            </button>
            <p style={{ marginTop: '0.75rem', fontWeight: 600 }}>{this.state.clickMessage}</p>

            {this.state.syntheticEventDetails.type && (
              <div style={{ marginTop: '1rem', padding: '1rem', backgroundColor: 'var(--bg-primary)', borderRadius: '8px', fontSize: '0.875rem' }}>
                <p><strong>SyntheticEvent Type:</strong> {this.state.syntheticEventDetails.type}</p>
                <p><strong>Target Element:</strong> {this.state.syntheticEventDetails.targetTagName}</p>
                <p><strong>Timestamp:</strong> {this.state.syntheticEventDetails.timestamp} ms</p>
              </div>
            )}
          </div>

        </div>
      </div>
    );
  }
}

export default EventHandling;
