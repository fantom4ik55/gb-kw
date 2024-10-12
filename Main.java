import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Animal {
    private String name;
    private List<String> commands;

    public Animal(String name) {
        this.name = name;
        this.commands = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<String> getCommands() {
        return commands;
    }

    public void addCommand(String command) {
        commands.add(command);
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }
}

class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }
}

class Hamster extends Animal {
    public Hamster(String name) {
        super(name);
    }
}

class Horse extends Animal {
    public Horse(String name) {
        super(name);
    }
}

class Camel extends Animal {
    public Camel(String name) {
        super(name);
    }
}

class Donkey extends Animal {
    public Donkey(String name) {
        super(name);
    }
}

public class Main {
    private static List<Animal> animals = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, "UTF-8");

        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1. Завести животное");
            System.out.println("2. Показать всех животных");
            System.out.println("3. Обучить животное новым командам");
            System.out.println("4. Увидеть список команд животного");
            System.out.println("5. Удалить животное");
            System.out.println("6. Выход");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline left-over

            switch (choice) {
                case 1: {
                    System.out.println("Выберите тип животного:");
                    System.out.println("1. Домашние животные");
                    System.out.println("2. Вьючные животные");
                    int type = scanner.nextInt();
                    scanner.nextLine(); // consume newline left-over

                    if (type == 1) {
                        System.out.println("Выберите домашнее животное:");
                        System.out.println("1. Собака");
                        System.out.println("2. Кошка");
                        System.out.println("3. Хомяк");
                        int domesticType = scanner.nextInt();
                        scanner.nextLine(); // consume newline left-over

                        System.out.println("Введите имя животного:");
                        String name = scanner.nextLine();

                        Animal animal = null;
                        switch (domesticType) {
                            case 1:
                                animal = new Dog(name);
                                break;
                            case 2:
                                animal = new Cat(name);
                                break;
                            case 3:
                                animal = new Hamster(name);
                                break;
                            default:
                                System.out.println("Неправильный выбор");
                                continue;
                        }
                        animals.add(animal);
                    } else if (type == 2) {
                        System.out.println("Выберите вьючное животное:");
                        System.out.println("1. Лошадь");
                        System.out.println("2. Верблюд");
                        System.out.println("3. Осёл");
                        int packType = scanner.nextInt();
                        scanner.nextLine(); // consume newline left-over

                        System.out.println("Введите имя животного:");
                        String name = scanner.nextLine();

                        Animal animal = null;
                        switch (packType) {
                            case 1:
                                animal = new Horse(name);
                                break;
                            case 2:
                                animal = new Camel(name);
                                break;
                            case 3:
                                animal = new Donkey(name);
                                break;
                            default:
                                System.out.println("Неправильный выбор");
                                continue;
                        }
                        animals.add(animal);
                    } else {
                        System.out.println("Неправильный выбор");
                        continue;
                    }
                    System.out.println("Животное заведено");
                    break;
                }
                case 2: {
                    System.out.println("Все животные:");
                    for (Animal animal : animals) {
                        System.out.println(animal.getName() + ": " + animal.getCommands());
                    }
                    break;
                }
                case 3: {
                    System.out.println("Введите имя животного для обучения:");
                    String animalName = scanner.nextLine();
                    Animal foundAnimal = null;
                    for (Animal animal : animals) {
                        if (animal.getName().equalsIgnoreCase(animalName)) {
                            foundAnimal = animal;
                            break;
                        }
                    }
                    if (foundAnimal != null) {
                        System.out.println("Введите новую команду для " + foundAnimal.getName() + ":");
                        String command = scanner.nextLine();
                        foundAnimal.addCommand(command);
                        System.out.println("Команда добавлена.");
                    } else {
                        System.out.println("Животное не найдено.");
                    }
                    break;
                }
                case 4: {
                    System.out.println("Введите имя животного, чтобы увидеть список команд:");
                    String animalName = scanner.nextLine();
                    Animal foundAnimal = null;
                    for (Animal animal : animals) {
                        if (animal.getName().equalsIgnoreCase(animalName)) {
                            foundAnimal = animal;
                            break;
                        }
                    }
                    if (foundAnimal != null) {
                        System.out.println("Команды для " + foundAnimal.getName() + ": " + foundAnimal.getCommands());
                    } else {
                        System.out.println("Животное не найдено.");
                    }
                    break;
                }
                case 5: {
                    System.out.println("Введите имя животного для удаления:");
                    String animalName = scanner.nextLine();
                    Animal foundAnimal = null;
                    for (Animal animal : animals) {
                        if (animal.getName().equalsIgnoreCase(animalName)) {
                            foundAnimal = animal;
                            break;
                        }
                    }
                    if (foundAnimal != null) {
                        animals.remove(foundAnimal);
                        System.out.println("Животное удалено.");
                    } else {
                        System.out.println("Животное не найдено.");
                    }
                    break;
                }
                case 6: {
                    System.out.println("Выход");
                    return;
                }
                default: {
                    System.out.println("Неправильный выбор");
                }
            }
        }
    }
}
