import React from 'react';
import './App.css';
import UserHobby from './components/UserHobby/UserHobby';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <h1>Hobby of the users</h1>
      </header>
      <main className="App-main">
        <UserHobby />
      </main>
    </div>
  );
}

export default App;
