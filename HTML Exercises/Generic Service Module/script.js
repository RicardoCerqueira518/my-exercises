class GenericService {
    constructor(name) {
      this.name = name;
      this.items = [];
    }
  
    add(item) {
      if (this.items.find((existingItem) => existingItem.id === item.id)){
        console.error(`Item com ID ${item.id} já existe`);
        return null;
      }
      this.items.push(item);
      return item;
    }
  
    remove(predicate) {
      const index = this.items.findIndex(predicate);
      if (index !== -1) {
        return this.items.splice(index, 1)[0];
      }
      return null;
    }
  
    update(predicate, updates) {
      const item = this.items.find(predicate);
      if (item) {
        Object.assign(item, updates); 
        return item; 
      }
      return null;
    }
  
    get(predicate) {
      return this.items.find(predicate) || null;
    }
  
    list() {
      return [...this.items];
    }
  
    destroy() {
      this.items = [];
    }
  }

  const myService = new GenericService("My Service");
  
  // Adicionar itens
  myService.add({ id: 1, name: "Item 1" });
  myService.add({ id: 2, name: "Item 2" });
  
  // Listar itens
  console.log(myService.list()); // [{ id: 1, name: "Item 1" }, { id: 2, name: "Item 2" }]
  
  // Atualizar um item
  myService.update(item => item.id === 1, { name: "Updated Item 1" });
  console.log(myService.list()); // [{ id: 1, name: "Updated Item 1" }, { id: 2, name: "Item 2" }]
  
  // Remover um item
  myService.remove(item => item.id === 2);
  console.log(myService.list()); // [{ id: 1, name: "Updated Item 1" }]
  
  // Obter um item
  console.log(myService.get(item => item.id === 1)); // { id: 1, name: "Updated Item 1" }
  
  // Destruir todos os itens
  myService.destroy();
  console.log(myService.list()); // []
  