import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Home from './pages/home/Home';
import Navbar from './components/Navbar';
import Footer from './components/Footer';
import Login from './pages/login/Login';
import Register from './pages/register/Register';
import About from './pages/about/About';
import Dummy from './pages/dummypage/dummyPage';
import Display from './pages/video/DisplayVideo';
import Upload from './pages/video/UploadVideo';
import VideoList from './components/VideoList';
import Courses from './pages/courses/Courses';

function App() {
    return (
        <Router>
            <Navbar />
            <Routes>
                <Route path="/login" element={<Login />} />
                <Route path="/courses" element={<VideoList />} />
                <Route path="/courses/:id" element={<Display />} /> {/* Fixed this path */}
                <Route path="/" element={<Home />} />
                <Route path="/about" element={<About />} />
                <Route path="/dummy" element={<Dummy />} />
                <Route path="/register" element={<Register />} />
                <Route path="/upload" element={<Upload />} />
                <Route path='/coursess' element={<Courses />} />
            </Routes>
            <Footer />
        </Router>
    );
}

export default App;
