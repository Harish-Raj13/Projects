import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import axios from 'axios';

function VideoList() {
    const [videos, setVideos] = useState([]);
    const [editingVideo, setEditingVideo] = useState(null);
    const [updatedName, setUpdatedName] = useState('');
    const [updatedDescription, setUpdatedDescription] = useState('');
    const [updatedFile, setUpdatedFile] = useState(null);
    const [loading, setLoading] = useState(false);  // Loading state for UX

    // Fetch videos function
    const fetchVideos = async () => {
        const response = await axios.get('http://localhost:8080/api/videos');
        setVideos(response.data);
    };

    useEffect(() => {
        fetchVideos(); // Call the fetchVideos function when the component mounts
    }, []);

    const deleteVideo = async (id) => {
        try {
            await axios.delete(`http://localhost:8080/api/video/${id}`);
            setVideos(videos.filter(video => video.id !== id));
        } catch (error) {
            console.error("Error deleting video:", error);
            alert("Failed to delete video!");
        }
    };

    const uploadVideo = async (file, name, description) => {
        const formData = new FormData();
        formData.append("file", file);
        formData.append("name", name);
        formData.append("description", description);

        try {
            const response = await axios.post('http://localhost:8080/api/video', formData, {
                headers: {
                    'Content-Type': 'multipart/form-data',
                }
            });
            setVideos((prevVideos) => [...prevVideos, response.data]);
        } catch (error) {
            console.error("Error uploading video:", error);
            alert("Failed to upload video!");
        }
    };

    const updateVideo = async (id) => {
        setLoading(true);  // Set loading state before making the request
        const formData = new FormData();
        formData.append("file", updatedFile);
        formData.append("name", updatedName);
        formData.append("description", updatedDescription);
    
        try {
            const response = await axios.put(`http://localhost:8080/api/video/${id}`, formData, {
                headers: {
                    'Content-Type': 'multipart/form-data',
                }
            });
    
            // After the update, refetch the video list to ensure it's updated
            await fetchVideos();
    
            // Reset the editing state
            setEditingVideo(null);
            setUpdatedName('');
            setUpdatedDescription('');
            setUpdatedFile(null);
        } catch (error) {
            console.error("Error updating video:", error);
            alert("Failed to update video!");
        } finally {
            setLoading(false);  // Reset loading state
        }
    };

    return (
        <div>
            <h2>All Videos</h2>
            <ul>
                {videos.map((video) => (
                    <li key={video.id}>
                        <Link to={`/courses/${video.id}`}>{video.name}</Link>
                        <button onClick={() => deleteVideo(video.id)}>Delete</button>
                        <button onClick={() => {
                            setEditingVideo(video);
                            setUpdatedName(video.name);
                            setUpdatedDescription(video.description);
                        }}>
                            Update
                        </button>
                    </li>
                ))}
            </ul>

            <div>
                <h3>Upload New Video</h3>
                <input type="file" id="file" />
                <input type="text" id="name" placeholder="Video Name" />
                <input type="text" id="description" placeholder="Video Description" />
                <button onClick={() => {
                    const file = document.getElementById("file").files[0];
                    const name = document.getElementById("name").value;
                    const description = document.getElementById("description").value;
                    uploadVideo(file, name, description);
                }}>
                    Upload Video
                </button>
            </div>

            {/* Update Video Form */}
            {editingVideo && (
                <div>
                    <h3>Update Video</h3>
                    <input
                        type="text"
                        value={updatedName}
                        onChange={(e) => setUpdatedName(e.target.value)}
                        placeholder="Updated Video Name"
                    />
                    <input
                        type="text"
                        value={updatedDescription}
                        onChange={(e) => setUpdatedDescription(e.target.value)}
                        placeholder="Updated Video Description"
                    />
                    <input
                        type="file"
                        onChange={(e) => setUpdatedFile(e.target.files[0])}
                    />
                    <button onClick={() => updateVideo(editingVideo.id)} disabled={loading}>
                        {loading ? 'Updating...' : 'Update Video'}
                    </button>
                    <button onClick={() => setEditingVideo(null)}>Cancel</button>
                </div>
            )}
        </div>
    );
}

export default VideoList;
