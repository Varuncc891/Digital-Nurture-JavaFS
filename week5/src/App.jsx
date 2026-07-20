import React from 'react';
import { HashRouter, Routes, Route, Link, useLocation } from 'react-router-dom';
import { 
  LayoutDashboard, User2, RefreshCw, MousePointer, 
  Plane, ClipboardCheck, Globe, Moon, Sun, ToggleLeft 
} from 'lucide-react';
import { ThemeProvider, useTheme } from './components/ThemeContext.jsx';
import ClassAndFuncComponent from './components/ClassAndFuncComponent.jsx';
import PropsAndState from './components/PropsAndState.jsx';
import LifecycleClock from './components/LifecycleClock.jsx';
import EventHandling from './components/EventHandling.jsx';
import ConditionalAndList from './components/ConditionalAndList.jsx';
import ValidatedForm from './components/ValidatedForm.jsx';
import ApiFetcher from './components/ApiFetcher.jsx';

const NavigationItem = ({ to, icon: Icon, label }) => {
  const location = useLocation();
  const isActive = location.pathname === to;
  return (
    <li className={`sidebar-item ${isActive ? 'active' : ''}`}>
      <Link to={to}>
        <Icon size={20} />
        <span>{label}</span>
      </Link>
    </li>
  );
};

const DashboardOverview = () => {
  return (
    <div>
      <div className="page-header">
        <h2 className="page-title">Welcome to the Academy Portal</h2>
        <p className="page-subtitle">Welcome to the first session of React. Here are the core statistics for this week's cohort. (Concept 1)</p>
      </div>

      <div className="card-grid">
        <div className="card glass">
          <div style={{ display: 'flex', alignItems: 'center', gap: '1rem' }}>
            <div style={{ padding: '0.75rem', borderRadius: '50%', backgroundColor: 'rgba(37,99,235,0.1)', color: 'var(--accent)' }}>
              <LayoutDashboard size={24} />
            </div>
            <div>
              <p style={{ color: 'var(--text-secondary)', fontSize: '0.875rem' }}>Active Concepts</p>
              <p style={{ fontSize: '1.75rem', fontWeight: 800 }}>19 / 19</p>
            </div>
          </div>
        </div>

        <div className="card glass">
          <div style={{ display: 'flex', alignItems: 'center', gap: '1rem' }}>
            <div style={{ padding: '0.75rem', borderRadius: '50%', backgroundColor: 'rgba(16,185,129,0.1)', color: '#10b981' }}>
              <Plane size={24} />
            </div>
            <div>
              <p style={{ color: 'var(--text-secondary)', fontSize: '0.875rem' }}>Open Flights</p>
              <p style={{ fontSize: '1.75rem', fontWeight: 800 }}>4 Routes</p>
            </div>
          </div>
        </div>

        <div className="card glass">
          <div style={{ display: 'flex', alignItems: 'center', gap: '1rem' }}>
            <div style={{ padding: '0.75rem', borderRadius: '50%', backgroundColor: 'rgba(245,158,11,0.1)', color: '#f59e0b' }}>
              <ClipboardCheck size={24} />
            </div>
            <div>
              <p style={{ color: 'var(--text-secondary)', fontSize: '0.875rem' }}>Forms Staged</p>
              <p style={{ fontSize: '1.75rem', fontWeight: 800 }}>2 Validated</p>
            </div>
          </div>
        </div>
      </div>

      <div className="card glass" style={{ marginTop: '2rem' }}>
        <h3 className="card-title">Concept coverage index</h3>
        <p style={{ color: 'var(--text-secondary)', marginTop: '0.5rem' }}>
          This React Dashboard compiles all requirements defined in Cognizant Academy's hands-on training materials.
          Use the left-hand navigation sidebar to traverse through the individual component test sheets (state variables, clock rendering, fetch operations, event listeners).
        </p>
      </div>
    </div>
  );
};

const DashboardContent = () => {
  const { theme, toggleTheme } = useTheme();
  
  return (
    <div className="app-container">
      <nav className="sidebar">
        <div className="sidebar-brand">
          <ToggleLeft size={24} />
          <span>React Dashboard</span>
        </div>

        <ul className="sidebar-menu">
          <NavigationItem to="/" icon={LayoutDashboard} label="Overview" />
          <NavigationItem to="/comparison" icon={User2} label="Component Types" />
          <NavigationItem to="/props-state" icon={ClipboardCheck} label="Props & State" />
          <NavigationItem to="/lifecycle" icon={RefreshCw} label="Lifecycle Clock" />
          <NavigationItem to="/events" icon={MousePointer} label="Event Handlers" />
          <NavigationItem to="/conditional-list" icon={Plane} label="Conditional & Lists" />
          <NavigationItem to="/forms" icon={ClipboardCheck} label="Validated Form" />
          <NavigationItem to="/fetch" icon={Globe} label="API Fetcher" />
        </ul>

        <button className="theme-toggle-btn" onClick={toggleTheme}>
          {theme === 'light' ? <Moon size={20} /> : <Sun size={20} />}
          <span>{theme === 'light' ? 'Dark Mode' : 'Light Mode'}</span>
        </button>
      </nav>

      <main className="main-content">
        <Routes>
          <Route path="/" element={<DashboardOverview />} />
          <Route path="/comparison" element={<ClassAndFuncComponent />} />
          <Route path="/props-state" element={<PropsAndState />} />
          <Route path="/lifecycle" element={<LifecycleClock />} />
          <Route path="/events" element={<EventHandling />} />
          <Route path="/conditional-list" element={<ConditionalAndList />} />
          <Route path="/forms" element={<ValidatedForm />} />
          <Route path="/fetch" element={<ApiFetcher />} />
        </Routes>
      </main>
    </div>
  );
};

const App = () => {
  return (
    <ThemeProvider>
      <HashRouter>
        <DashboardContent />
      </HashRouter>
    </ThemeProvider>
  );
};

export default App;
