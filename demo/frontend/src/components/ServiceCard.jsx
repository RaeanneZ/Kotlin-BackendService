import "./ServiceCard.css";

export default function ServiceCard({ card, onChoose }) {
    return (
        <div className="svc-card">
            <div className="svc-header">
                <div className="svc-category">{card.category}</div>
                <div className="svc-title">{card.title}</div>
            </div>

            <div className="svc-body">
                <div className="svc-tags">
                    {card.tags.map((tag) => (
                        <span key={tag} className="svc-tag">
              {tag}
            </span>
                    ))}
                </div>

                <p className="svc-description">{card.description}</p>

                <div className="svc-footer">
                    <button className="svc-button" onClick={() => onChoose(card.id)}>
                        CHOOSE
                    </button>
                </div>
            </div>
        </div>
    );
}