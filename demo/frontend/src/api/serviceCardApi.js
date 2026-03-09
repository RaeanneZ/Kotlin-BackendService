// This file talks to your Spring Boot backend.
const BASE_URL = "http://localhost:8080";

// GET
export async function getAllCards() {
    const response = await fetch(`${BASE_URL}/api/service-cards`);

    if (!response.ok) {
        throw new Error("Failed to fetch cards");
    }

    return response.json();
}

// POST
export async function createCard(cardData) {
    const response = await fetch(`${BASE_URL}/api/service-cards`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(cardData),
    });

    if (!response.ok) {
        throw new Error("Failed to create card");
    }

    return response.json();
}

// PUT
export async function updateCard(id, cardData) {
    const response = await fetch(`${BASE_URL}/api/service-cards/${id}`, {
        method: "PUT",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(cardData),
    });

    if (!response.ok) {
        throw new Error("Failed to update card");
    }

    return response.json();
}

// DELETE
export async function deleteCard(id) {
    const response = await fetch(`${BASE_URL}/api/service-cards/${id}`, {
        method: "DELETE",
    });

    if (!response.ok) {
        throw new Error("Failed to delete card");
    }
}