import React, { Component } from 'react';

// Class Component (HOL 2 - Student Management Portal)
export class ClassComponentDemo extends Component {
  constructor(props) {
    super(props);
    this.state = {
      message: "Welcome to the Home page of Student Management Portal (Class Component)"
    };
  }

  render() {
    return (
      <div className="card glass">
        <h3 className="card-title">Class Component</h3>
        <p style={{ color: 'var(--text-secondary)' }}>{this.state.message}</p>
        <div style={{ marginTop: '1rem', borderTop: '1px solid var(--border)', paddingTop: '1rem' }}>
          <h4>Portal Admin Message:</h4>
          <p style={{ fontStyle: 'italic', color: 'var(--accent)' }}>"{this.props.adminNote || 'Default Portal Message'}"</p>
        </div>
      </div>
    );
  }
}

// Functional Component (HOL 2 - Student Management Portal)
export const FunctionalComponentDemo = ({ adminNote }) => {
  return (
    <div className="card glass">
      <h3 className="card-title">Functional Component</h3>
      <p style={{ color: 'var(--text-secondary)' }}>
        Welcome to the About/Contact details section of the Student Management Portal (Functional Component).
      </p>
      <div style={{ marginTop: '1rem', borderTop: '1px solid var(--border)', paddingTop: '1rem' }}>
        <h4>Portal Guidelines:</h4>
        <p style={{ fontStyle: 'italic', color: 'var(--accent)' }}>"{adminNote || 'Default Guidelines Content'}"</p>
      </div>
    </div>
  );
};

const ClassAndFuncComponent = () => {
  return (
    <div>
      <div className="page-header">
        <h2 className="page-title">Components structure comparison</h2>
        <p className="page-subtitle">Demonstrates Class components vs Functional components (concepts 2 & 3).</p>
      </div>
      <div className="card-grid">
        <ClassComponentDemo adminNote="Make sure to register all student cohorts by end of week." />
        <FunctionalComponentDemo adminNote="Functional components are clean, hook-friendly, and modern." />
      </div>
    </div>
  );
};

export default ClassAndFuncComponent;
