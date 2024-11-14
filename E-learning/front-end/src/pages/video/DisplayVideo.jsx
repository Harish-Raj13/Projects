import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom'; // Hook to get the ID from the URL
import axios from 'axios';

function DisplayVideo() {
    const { id } = useParams(); // Extract video ID from URL
    const [videoSrc, setVideoSrc] = useState(null);
    const [name, setName] = useState('');
    const [description, setDescription] = useState('');

    useEffect(() => {
        // Fetch the video data based on the ID
        const fetchVideo = async () => {
            const response = await axios.get(`http://localhost:8080/api/video/${id}`, { responseType: 'blob' });
            setVideoSrc(URL.createObjectURL(response.data));  // Create URL for video blob
        };
        fetchVideo();
    }, [id]);

    return (
        <div>
            {videoSrc && (
                <div>
                    <h3>{name}</h3>
                    <p>{description}</p>
                    <video width="600" controls>
                        <source src={videoSrc} type="video/mp4" />
                        Your browser does not support the video tag.
                    </video>
                </div>
            )}
        </div>
    );
}

export default DisplayVideo;
