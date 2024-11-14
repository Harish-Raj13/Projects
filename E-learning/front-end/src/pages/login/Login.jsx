import React, { useState } from 'react';
import axios from 'axios';
import { Link, useNavigate } from 'react-router-dom';
import {jwtDecode} from 'jwt-decode'; // Named import of jwtDecode

const Login = () => {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [error, setError] = useState('');
  const navigate = useNavigate();

  // Function to check if the token is expired
  const isTokenExpired = (token) => {
    if (!token) {
      console.log("No token provided");
      return true; // Treat missing token as expired
    }

    try {
      const decoded = jwtDecode(token);
      const exp = decoded.exp;
      const currentTime = Math.floor(Date.now() / 1000); // Current time in seconds
      return exp < currentTime;
    } catch (error) {
      console.error("Error decoding token:", error);
      return false; // If there's an error, assume the token isn't expired
    }
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    setError(''); // Clear previous error messages
    try {
      const response = await axios.post('http://localhost:8080/login', { username, password });

      if (response.status === 200 && response.data) {
        const token = response.data.startsWith('Bearer ') ? response.data.split(' ')[1] : response.data;
        console.log('Saving token to localStorage:', token); 
        localStorage.setItem('jwtToken', token); // Save token to localStorage

        // Check if the token is valid
        const expired = isTokenExpired(token);
        if (expired) {
          console.log('Token expired');
          localStorage.removeItem('jwtToken'); // Remove expired token
          setError('Token expired. Please log in again.');
          return;
        }

        alert('Login successful');
        navigate('/dummy');
      } else {
        setError('Invalid credentials');
      }
    } catch (error) {
      if (error.response) {
        setError(error.response.data.message || 'Login failed.');
      } else {
        setError('Network error. Please try again later.');
      }
    }
  };

  return (
    <div>
      <h2>Login</h2>
      {error && <div style={{ color: 'red' }}>{error}</div>}
      <form onSubmit={handleSubmit}>
        <div>
          <label>Username:</label>
          <input type="text" value={username} onChange={(e) => setUsername(e.target.value)} />
        </div>
        <div>
          <label>Password:</label>
          <input type="password" value={password} onChange={(e) => setPassword(e.target.value)} />
        </div>
        <button type="submit">Login</button>
        <p>
          Don't have an account? <Link to="/register">Register</Link>
        </p>
      </form>
    </div>
  );
};

export default Login;
