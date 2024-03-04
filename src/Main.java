// Шаг 1: Создать интерфейс HavingSuperAbility
interface HavingSuperAbility {
    void applySuperAbility();
}

// Шаг 2: Создать абстрактный класс Hero
abstract class Hero implements HavingSuperAbility {
    int health;
    int damage;
    String superAbilityType;

    public Hero(int health, int damage, String superAbilityType) {
        this.health = health;
        this.damage = damage;
        this.superAbilityType = superAbilityType;
    }
}

// Шаг 3: Создать классы героев Magic, Medic, Warrior
class Magic extends Hero {
    public Magic(int health, int damage) {
        super(health, damage, "MAGIC");
    }

    @Override
    public void applySuperAbility() {
        System.out.println("Magic применил суперспособность MAGIC ATTACK");
    }
}

class Medic extends Hero {
    private int healPoints;

    public Medic(int health, int damage, int healPoints) {
        super(health, damage, "MEDIC");
        this.healPoints = healPoints;
    }

    @Override
    public void applySuperAbility() {
        System.out.println("Medic применил суперспособность HEALING PULSE");
    }

    public void increaseExperience() {
        healPoints += healPoints * 0.1;
        System.out.println("Опыт лечения увеличен. Текущее количество единиц лечения: " + healPoints);
    }
}

class Warrior extends Hero {
    public Warrior(int health, int damage) {
        super(health, damage, "WARRIOR");
    }

    @Override
    public void applySuperAbility() {
        System.out.println("Warrior применил суперспособность CRITICAL DAMAGE");
    }
}

// Шаг 4: Создать класс Main
public class Main {
    public static void main(String[] args) {
        // Создание массива из 3х разных героев
        Hero[] heroes = {new Magic(100, 20), new Medic(120, 15, 50), new Warrior(150, 25)};

        // Применение суперспособности каждого героя через цикл
        for (Hero hero : heroes) {
            hero.applySuperAbility();

            // Проверка, является ли герой объектом класса Medic
            if (hero instanceof Medic) {
                // Приведение типа и вызов метода increaseExperience
                ((Medic) hero).increaseExperience();
            }
        }
    }
}
