import React, { useState, useEffect } from 'react';
import axios from 'axios';

export const DataFetching = () => {

    const [posts, setPosts] = useState([]);

    const fetchData = async () => {
        try {
            console.log("Fetching posts...");
            const response = await axios.get('https://jsonplaceholder.typicode.com/posts');
            console.log("API response:", response.data);
            setPosts(response.data);
        } catch (error) {
            console.error("Axios API error:", error);
        }
    };

    useEffect(() => {
        fetchData().then(r => console.log("Data fetching completed"));
    }, []);

    return (
        <div>
            <h1>Data Fetching</h1>
            <ul>
                {posts.map(post => (<li key={post.id}>{post.title}</li>))}
            </ul>
        </div>
    );
};
