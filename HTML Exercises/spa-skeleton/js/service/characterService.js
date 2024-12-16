async function getCharacter() {
    let url = "https://narutodb.xyz/api/character/{id}";
    try {
        const response = await fetch(url);
        if (!response.ok) throw new Error("Falha ao buscar imagem");

        const characters = await response.json();

        return characters.map(character => ({
            id: character.id,
            name: character.name,
            images: character.image,    
        }));

    } catch (error) {
        handleError(error.message);
    }
}

async function getAllCharacters() {
    let url = "https://narutodb.xyz/api/character";
    try {
        const response = await fetch(url);
        if (!response.ok) throw new Error("Falha ao buscar imagem");

        const { characters } = await response.json();

        return characters.map(character => ({
            id: character.id,
            name: character.name,
            images: character.images
        }));

    } catch (error) {
        handleError(error.message);
    }
}

function handleError(message) {
    console.log(message);
}


export default { getCharacter, getAllCharacters };