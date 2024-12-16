import characterService from '../service/characterService.js';
import characterView from '../view/characterView.js';

export async function init() {
    const characters = await characterService.getAllCharacters();

    characterView.render(characters, characterService.getCharacter);
}
