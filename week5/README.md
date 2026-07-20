# Week 5: React Single Page Application (SPA)

This directory contains the hands-on React SPA built using Vite. It acts as a comprehensive showcase covering all 19 React training concepts.

## Features & Topics Covered

* **JSX & React Elements**: Found in `src/App.jsx` and component templates.
* **Component Structures**: Functional vs Class components comparison (`src/components/ClassAndFuncComponent.jsx`).
* **Props & State**: Dynamic configuration mapping and counter state modifications (`src/components/PropsAndState.jsx`).
* **Component Lifecycle**: Live mounting clock leveraging hook updates (`src/components/LifecycleClock.jsx`).
* **Styling Options**: CSS Modules and dynamic inline transitions (`src/components/ThemeContext.jsx` & `src/App.css`).
* **Event Handlers**: Inputs and counter clicks (`src/components/EventHandling.jsx`).
* **Lists & Keys**: Arrays mapped with unique item keys (`src/components/ConditionalAndList.jsx`).
* **Forms & Validations**: Controlled contact registration forms with real-time error checking (`src/components/ValidatedForm.jsx`).
* **API Consumption**: Fetches dynamic datasets using native browser fetch integrations (`src/components/ApiFetcher.jsx`).
* **Unit Testing**: Suite validating element functions via Vitest runner (`src/App.test.jsx`).

---

## Local Setup

Install local packages:
```bash
npm install
```

### Run Tests
```bash
npm run test
```

### Start Development Server
```bash
npm run dev
```

### Production Build
```bash
npm run build
```
The output builds will be stored in `dist/`.
