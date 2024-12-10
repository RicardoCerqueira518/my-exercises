/**
 * Creates a counter module with an initial value, zero if not provided
 */
exports.createCounter = function (counter = 0) {

    return {
        increment: function (number) {
            return counter++;
        },
        get: function () {
            return counter;
        },
        reset: function () {
            return counter = 0;
        }
    }
};

/**
 * Creates a person module with name and age
 * An initial name value should be provided and
 * an exception thrown if not
 */
exports.createPerson = function (name, age=0) {
    if (!name) {
        throw new Error("Não existe")
    }

    return {
        getName: function () {
            return name;
        },
        getAge: function () {
            return age;
        },
        setAge: function (newAge) {
            age = newAge;
        }
    }

};