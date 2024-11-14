// DummyPage.jsx or any protected component
import React, { useEffect } from 'react';
import { jwtDecode } from 'jwt-decode';  // Correct import of jwt-decode
import { useNavigate } from 'react-router-dom';

const DummyPage = () => {
    const navigate = useNavigate();

    useEffect(() => {
        const token = localStorage.getItem('jwtToken');
        
        if (!token) {
            console.log("No token found");
            navigate('/login'); // Redirect to login if no token
            return;
        }

        try {
            const decodedToken = jwtDecode(token); // Decode the JWT token

            // Check if token is expired
            const currentTime = Date.now() / 1000; // Convert to seconds
            if (decodedToken.exp < currentTime) {
                console.log("Token has expired");
                localStorage.removeItem('jwtToken'); // Remove expired token
                navigate('/login'); // Redirect to login if token expired
            } else {
                console.log("Token is valid");
            }
        } catch (error) {
            console.error("Failed to decode token", error);
            localStorage.removeItem('jwtToken');
            navigate('/login'); // Handle invalid token
        }
    }, [navigate]);

    return (
        <div>
            <h2>Welcome to the Dummy Page</h2>
            <p>This is a protected page that you can only see after successful login!</p>
        </div>
    );
};

export default DummyPage;
