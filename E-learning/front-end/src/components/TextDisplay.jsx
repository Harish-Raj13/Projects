import React, { useState, useEffect } from 'react';
import axios from 'axios';

const TextDisplay = () => {
  const [text, setText] = useState('');

  useEffect(() => {
    axios.get('http://localhost:8080/api/text/fetch')
      .then((response) => {
        setText(response.data);
      })
      .catch((error) => {
        console.error('Error fetching text:', error);
      });
  }, []);

  return (
    <div>
      <h1>Text from Database:</h1>
      <p>{text}</p>
    </div>
  );
}

export default TextDisplay;
