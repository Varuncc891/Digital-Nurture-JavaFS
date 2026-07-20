import React, { useState } from 'react';

export const ValidatedForm = () => {
  const [formData, setFormData] = useState({
    name: '',
    email: '',
    message: ''
  });

  const [errors, setErrors] = useState({});
  const [submittedData, setSubmittedData] = useState(null);

  const validate = () => {
    const tempErrors = {};
    if (!formData.name.trim()) {
      tempErrors.name = "Name is required";
    } else if (formData.name.length < 3) {
      tempErrors.name = "Name must be at least 3 characters";
    }

    if (!formData.email) {
      tempErrors.email = "Email is required";
    } else if (!/\S+@\S+\.\S+/.test(formData.email)) {
      tempErrors.email = "Email must be a valid email address";
    }

    if (!formData.message.trim()) {
      tempErrors.message = "Message is required";
    } else if (formData.message.length < 10) {
      tempErrors.message = "Message must be at least 10 characters";
    }

    setErrors(tempErrors);
    return Object.keys(tempErrors).length === 0;
  };

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prev) => ({
      ...prev,
      [name]: value
    }));
    // Real-time clear error for that field
    if (errors[name]) {
      setErrors((prev) => ({ ...prev, [name]: "" }));
    }
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    if (validate()) {
      setSubmittedData({ ...formData });
      setFormData({ name: '', email: '', message: '' });
      setErrors({});
    }
  };

  return (
    <div className="card glass">
      <div className="page-header">
        <h2 className="page-title">Contact & Query Registration Form</h2>
        <p className="page-subtitle">Demonstrates controlled input elements, real-time validations, and submission handlers (concepts 15 & 16).</p>
      </div>

      <form onSubmit={handleSubmit} style={{ display: 'flex', flexDirection: 'column', gap: '1rem', marginTop: '1rem' }} noValidate>
        <div className="form-group">
          <label className="form-label" htmlFor="name">Full Name</label>
          <input 
            type="text" 
            id="name" 
            name="name" 
            className="form-input" 
            value={formData.name} 
            onChange={handleChange}
            placeholder="John Doe" 
          />
          {errors.name && <span className="form-error">{errors.name}</span>}
        </div>

        <div className="form-group">
          <label className="form-label" htmlFor="email">Email Address</label>
          <input 
            type="email" 
            id="email" 
            name="email" 
            className="form-input" 
            value={formData.email} 
            onChange={handleChange}
            placeholder="john.doe@example.com" 
          />
          {errors.email && <span className="form-error">{errors.email}</span>}
        </div>

        <div className="form-group">
          <label className="form-label" htmlFor="message">Message / Queries</label>
          <textarea 
            id="message" 
            name="message" 
            className="form-textarea" 
            rows="4" 
            value={formData.message} 
            onChange={handleChange}
            placeholder="Write your details here..."
          />
          {errors.message && <span className="form-error">{errors.message}</span>}
        </div>

        <button type="submit" className="btn btn-primary" style={{ alignSelf: 'flex-start' }}>
          Submit Query
        </button>
      </form>

      {submittedData && (
        <div style={{ marginTop: '2rem', padding: '1.5rem', border: '1px solid #10b981', borderRadius: '8px', backgroundColor: 'rgba(16, 185, 129, 0.05)' }}>
          <h4 style={{ color: '#10b981', marginBottom: '0.5rem' }}>✓ Registration Details Submitted</h4>
          <p><strong>Name:</strong> {submittedData.name}</p>
          <p><strong>Email:</strong> {submittedData.email}</p>
          <p><strong>Message:</strong> {submittedData.message}</p>
        </div>
      )}
    </div>
  );
};

export default ValidatedForm;
