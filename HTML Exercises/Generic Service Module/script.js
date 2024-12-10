const GenericService = (function () {
  function createService(name) {
    const items = []; 

    return {
      name, 


      add(item) {
        items.push(item);
        return item;
      },

  
      remove(predicate) {
        const index = items.findIndex(predicate);
        if (index !== -1) {
          return items.splice(index, 1)[0];
        }
        return null;
      },

 
      update(predicate, updates) {
        const item = items.find(predicate);
        if (item) {
          Object.assign(item, updates);
          return item;
        }
        return null;
      },

  
      get(predicate) {
        return items.find(predicate) || null;
      },


      list() {
        return [...items]; // Retorna uma cópia do array
      },

 
      destroy() {
        items.length = 0; // Limpa o array
      },
    };
  }


  return {
    createService,
  };
})();


const myService = GenericService.createService("My Service");

// Adicionando itens
myService.add({ id: 1, name: "Item 1" });
myService.add({ id: 2, name: "Item 2" });

// Listando itens
console.log(myService.list()); // [{ id: 1, name: "Item 1" }, { id: 2, name: "Item 2" }]

// Atualizando um item
myService.update(item => item.id === 1, { name: "Updated Item 1" });
console.log(myService.list()); // [{ id: 1, name: "Updated Item 1" }, { id: 2, name: "Item 2" }]

// Removendo um item
myService.remove(item => item.id === 2);
console.log(myService.list()); // [{ id: 1, name: "Updated Item 1" }]

// Obtendo um item específico
console.log(myService.get(item => item.id === 1)); // { id: 1, name: "Updated Item 1" }

// Destruindo todos os itens
myService.destroy();
console.log(myService.list()); // []

  