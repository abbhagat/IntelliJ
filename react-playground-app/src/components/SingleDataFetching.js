import React, { useState, useEffect } from 'react';
import axios from 'axios';

export const SingleDataFetching = () => {

    const [post, setPost] = useState([]);
    const [id, setId] = useState(1);
    const [idFromButton, setIdFromButton] = useState(1);

    const fetchData = async () => {
        try {
            console.log("Fetching posts...");
            const response = await axios.get(`https://jsonplaceholder.typicode.com/posts/${id}`);
            console.log("API response:", response.data);
            setPost(response.data);
        } catch (error) {
            console.error("Axios API error:", error);
        }
    };

    // useEffect(() => {
    //     fetchData().then(r => console.log("Data fetching completed"));
    // }, [id]);

    useEffect(() => {
        fetchData().then(r => console.log("Data fetching completed"));
    }, [idFromButton]);

    return (
        <div>
            <input type="text" placeholder="Search..." value={id} onChange={e => setId(Number(e.target.value))}/>
            <button type="button" onClick={() => setIdFromButton(id)}>Fetch Post</button>
            <ul>
                <li key={post.id}>{post.title}</li>
            </ul>
        </div>
    );
};
