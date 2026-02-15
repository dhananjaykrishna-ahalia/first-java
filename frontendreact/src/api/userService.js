/**
 * Fetches user details by ID.
 * @param {string} userId - The ID of the user.
 * @returns {Promise<Object>} - A promise that resolves with user details.
 */
export const fetchUser = async (userId) => {
    const response = await fetch(`http://localhost:8080/api/users/${userId}`);
    if (!response.ok) {
        throw new Error('Failed to fetch user details');
    }
    return response.json();
};

/**
 * Fetches hobby details by name.
 * @param {string} hobbyName - The name of the hobby.
 * @returns {Promise<Object>} - A promise that resolves with hobby details.
 */
export const fetchHobby = async (hobbyName) => {
    const response = await fetch(`http://localhost:8080/api/hobbies/${hobbyName}`);
    if (!response.ok) {
        throw new Error('Failed to fetch hobby details');
    }
    return response.json();
};

/**
 * Fetches user and/or hobby details independently.
 * @param {string} userId - The ID of the user (optional).
 * @param {string} hobbyName - The name of the hobby (optional).
 * @returns {Promise<Object>} - A promise that resolves with combined details.
 */
export const fetchUserDetails = async (userId, hobbyName) => {
    let user = null;
    let hobby = null;

    const promises = [];

    if (userId) {
        promises.push(
            fetchUser(userId)
                .then((data) => {
                    user = data;
                })
                .catch((error) => {
                    console.warn(`Failed to fetch user '${userId}':`, error);
                })
        );
    }

    if (hobbyName) {
        promises.push(
            fetchHobby(hobbyName)
                .then((data) => {
                    hobby = data;
                })
                .catch((error) => {
                    console.warn(`Failed to fetch hobby '${hobbyName}':`, error);
                })
        );
    }

    await Promise.all(promises);
    return { user, hobby };
};
