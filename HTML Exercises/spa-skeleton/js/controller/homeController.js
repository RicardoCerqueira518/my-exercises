import homeView from '../view/homeView.js';
import characterService from '../service/characterService.js';

export function init() {
    homeView.render(characterService.getCharacter);
}
