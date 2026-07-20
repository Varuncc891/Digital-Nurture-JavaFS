import React, { Component } from 'react';

// CalculateScore Functional Component (HOL 3)
export const CalculateScore = ({ name, school, total, goal }) => {
  const average = (total / goal).toFixed(2);
  const status = average >= 0.75 ? "Excellent Pass" : "Needs Improvement";

  return (
    <div className="card glass">
      <h3 className="card-title">Score Calculator</h3>
      <div style={{ display: 'flex', flexDirection: 'column', gap: '0.5rem', color: 'var(--text-secondary)' }}>
        <p><strong>Student Name:</strong> {name}</p>
        <p><strong>School:</strong> {school}</p>
        <p><strong>Score Total:</strong> {total}</p>
        <p><strong>Maximum Goal:</strong> {goal}</p>
        <p><strong>Average Ratio:</strong> <span style={{ color: 'var(--accent)', fontWeight: 700 }}>{average}</span></p>
        <p><strong>Remarks:</strong> <span style={{ fontWeight: 600, color: average >= 0.75 ? '#10b981' : '#f59e0b' }}>{status}</span></p>
      </div>
    </div>
  );
};

// CountPeople Class Component (HOL 8)
export class CountPeople extends Component {
  constructor(props) {
    super(props);
    this.state = {
      entrycount: 0,
      exitcount: 0
    };
    this.updateEntry = this.updateEntry.bind(this);
    this.updateExit = this.updateExit.bind(this);
  }

  updateEntry() {
    this.setState((prevState) => ({
      entrycount: prevState.entrycount + 1
    }));
  }

  updateExit() {
    this.setState((prevState) => ({
      exitcount: prevState.exitcount + 1
    }));
  }

  render() {
    return (
      <div className="card glass">
        <h3 className="card-title">Mall Visitor Counter</h3>
        <div style={{ display: 'flex', gap: '2rem', marginBottom: '1rem' }}>
          <div>
            <p style={{ color: 'var(--text-secondary)' }}>Entered</p>
            <p style={{ fontSize: '2rem', fontWeight: 800 }}>{this.state.entrycount}</p>
          </div>
          <div>
            <p style={{ color: 'var(--text-secondary)' }}>Exited</p>
            <p style={{ fontSize: '2rem', fontWeight: 800 }}>{this.state.exitcount}</p>
          </div>
        </div>
        <div style={{ display: 'flex', gap: '1rem' }}>
          <button className="btn btn-primary" onClick={this.updateEntry}>Update Entry</button>
          <button className="btn btn-secondary" onClick={this.updateExit}>Update Exit</button>
        </div>
      </div>
    );
  }
}

const PropsAndState = () => {
  return (
    <div>
      <div className="page-header">
        <h2 className="page-title">Props & State Mapping</h2>
        <p className="page-subtitle">Demonstrates passing props (CalculateScore) and state mutations (CountPeople) in React.</p>
      </div>
      <div className="card-grid">
        <CalculateScore name="Alice Johnson" school="Cognizant Academy" total={360} goal={400} />
        <CountPeople />
      </div>
    </div>
  );
};

export default PropsAndState;
