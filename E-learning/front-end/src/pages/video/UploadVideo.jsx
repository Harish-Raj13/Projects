import React, { useState } from 'react';
import axios from 'axios';

function VideoUpload() {
    const [file, setFile] = useState(null);
    const [name, setName] = useState('');
    const [description, setDescription] = useState('');
    const [message, setMessage] = useState('');

    const handleFileChange = (e) => {
        setFile(e.target.files[0]);
    };

    const handleSubmit = async (e) => {
        e.preventDefault();

        const formData = new FormData();
        formData.append('file', file);
        formData.append('name', name);
        formData.append('description', description);

        try {
            const response = await axios.post('http://localhost:8080/api/video', formData, {
                headers: {
                    'Content-Type': 'multipart/form-data',
                },
            });
            setMessage('Video uploaded successfully!');
        } catch (error) {
            setMessage('Error uploading video');
        }
    };

    return (
        <div>
            <h2>Upload Video</h2>
            <form onSubmit={handleSubmit}>
                <input
                    type="file"
                    accept="video/*"
                    onChange={handleFileChange}
                />
                <input
                    type="text"
                    placeholder="Video Name"
                    value={name}
                    onChange={(e) => setName(e.target.value)}
                />
                <textarea
                    placeholder="Video Description"
                    value={description}
                    onChange={(e) => setDescription(e.target.value)}
                />
                <button type="submit">Upload Video</button>
            </form>
            {message && <p>{message}</p>}
        </div>
    );
}

export default VideoUpload;
