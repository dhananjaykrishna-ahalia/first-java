import React, { useState } from 'react';
import { fetchUserDetails } from '../../api/userService';
import './UserHobby.css';

const UserHobby = () => {
    const [userId, setUserId] = useState('');
    const [hobby, setHobby] = useState('');
    const [fetchedData, setFetchedData] = useState(null);
    const [loading, setLoading] = useState(false);
    const [error, setError] = useState(null);

    const handleSubmit = async () => {
        if (!userId && !hobby) {
            setError('Please enter at least one field (User ID or Hobby).');
            return;
        }

        setLoading(true);
        setError(null);
        setFetchedData(null);

        try {
            const data = await fetchUserDetails(userId, hobby);

            if (!data.user && !data.hobby) {
                setError('No details found for the provided inputs.');
            } else {
                setFetchedData(data);
            }
        } catch (err) {
            setError('An unexpected error occurred. Please try again.');
        } finally {
            setLoading(false);
        }
    };

    return (
        <div className="user-hobby-container">
            <div className="input-section">
                <div className="input-group">
                    <label htmlFor="userId">User ID:</label>
                    <input
                        type="text"
                        id="userId"
                        value={userId}
                        onChange={(e) => setUserId(e.target.value)}
                        placeholder="Enter User ID"
                    />
                </div>
                <div className="input-group">
                    <label htmlFor="hobby">Hobby:</label>
                    <input
                        type="text"
                        id="hobby"
                        value={hobby}
                        onChange={(e) => setHobby(e.target.value)}
                        placeholder="Enter Hobby"
                    />
                </div>
                <button className="submit-button" onClick={handleSubmit} disabled={loading}>
                    {loading ? 'Submitting...' : 'Submit'}
                </button>
                {error && <p className="error-message">{error}</p>}
            </div>

            {fetchedData && (
                <div className="result-section">
                    <h2>Fetched Details</h2>

                    {fetchedData.user && (
                        <div className="section-block">
                            <h3>User Information</h3>
                            <div className="result-item">
                                <strong>ID:</strong> {fetchedData.user.userid}
                            </div>
                            <div className="result-item">
                                <strong>Role:</strong> {fetchedData.user.role}
                            </div>
                            <div className="result-item">
                                <strong>Description:</strong> {fetchedData.user.description}
                            </div>
                        </div>
                    )}

                    {fetchedData.hobby && (
                        <div className="section-block">
                            <h3>Hobby Information</h3>
                            <div className="result-item">
                                <strong>Name:</strong> {fetchedData.hobby.hobbyName}
                            </div>
                            <div className="result-item">
                                <strong>Description:</strong> {fetchedData.hobby.hobbyDescription}
                            </div>
                        </div>
                    )}
                </div>
            )}
        </div>
    );
};

export default UserHobby;
