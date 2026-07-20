import { describe, test, expect } from 'vitest';
import React from 'react';
import ReactDOM from 'react-dom/client';
import { act } from 'react-dom/test-utils';
import { CalculateScore, CountPeople } from './components/PropsAndState.jsx';
import { FunctionalComponentDemo } from './components/ClassAndFuncComponent.jsx';

describe('React Training Components Unit Tests', () => {
  test('CalculateScore displays score and average', () => {
    const container = document.createElement('div');
    document.body.appendChild(container);

    act(() => {
      ReactDOM.createRoot(container).render(
        <CalculateScore name="Alice Johnson" school="Cognizant Academy" total={300} goal={400} />
      );
    });

    expect(container.textContent).toContain('Alice Johnson');
    expect(container.textContent).toContain('0.75');
    expect(container.textContent).toContain('Excellent Pass');

    document.body.removeChild(container);
  });

  test('FunctionalComponentDemo displays portal guidelines', () => {
    const container = document.createElement('div');
    document.body.appendChild(container);

    act(() => {
      ReactDOM.createRoot(container).render(
        <FunctionalComponentDemo adminNote="Test Guidelines" />
      );
    });

    expect(container.textContent).toContain('Test Guidelines');

    document.body.removeChild(container);
  });

  test('CountPeople initializes with entry and exit counts at zero', () => {
    const container = document.createElement('div');
    document.body.appendChild(container);

    act(() => {
      ReactDOM.createRoot(container).render(
        <CountPeople />
      );
    });

    expect(container.textContent).toContain('Entered');
    expect(container.textContent).toContain('Exited');

    document.body.removeChild(container);
  });
});
