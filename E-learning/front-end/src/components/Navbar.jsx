import React from 'react';
import { Link, useLocation, useNavigate } from 'react-router-dom';
import './Navbar.css';

const Navbar = () => {
  const location = useLocation();
  const navigate = useNavigate(); // Used for navigation
  const isDummyPage = location.pathname === '/dummy';
  const isCourses = location.pathname === '/courses';
  const isVideoDetail = location.pathname.includes('/courses/');

  const handleLogout = () => {
    // Clear authentication state (e.g., remove JWT token from localStorage)
    localStorage.removeItem('authToken');  // Example: Remove token if you're using localStorage

    // Optionally, clear other user session data, if any
    // sessionStorage.removeItem('user');

    // Redirect to the login page
    navigate('/login');
  };

  const handleBack = () => {
    navigate('/courses'); // Navigate back to the video list
  };

  return (
    <nav>
      <div className="logo">Your Logo</div>
      <div className="link">
        {isVideoDetail ? (
          <button onClick={handleBack}>Back to Video List</button>
        ) : isCourses ? (
          <button onClick={handleLogout}>
            Logout
          </button>
        ) : isDummyPage ? (
          <Link to="/courses">Courses</Link>
        ) : (
          <>
            <Link to="/">Home</Link>
            <Link to="/coursess">Courses</Link>
            <Link to="/about">About</Link>
            <Link to="/login">Login</Link>
          </>
        )}
      </div>
    </nav>
  );
};

export default Navbar;
