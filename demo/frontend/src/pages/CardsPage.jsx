import { useEffect, useState } from "react";
import { getAllCards } from "../api/serviceCardApi";
import ServiceCard from "../components/ServiceCard";

export default function CardsPage() {
    const [cards, setCards] = useState([]);
    const [error, setError] = useState("");

    useEffect(() => {
        async function loadCards() {
            try {
                const data = await getAllCards();
                setCards(data);
            } catch (err) {
                setError(err.message);
            }
        }

        loadCards();
    }, []);

    function handleChoose(id) {
        alert(`Chosen card id: ${id}`);
    }

    return (
        <div style={{ padding: "24px" }}>
            <h1>Service Cards</h1>

            {error && <p style={{ color: "red" }}>{error}</p>}

            <div
                style={{
                    display: "flex",
                    gap: "20px",
                    flexWrap: "wrap",
                    marginTop: "20px",
                }}
            >
                {cards.map((card) => (
                    <ServiceCard key={card.id} card={card} onChoose={handleChoose} />
                ))}
            </div>
        </div>
    );
}