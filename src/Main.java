public class Main {
    /*
    * Реализована игри, которая заключается в создании в стране городов,
    * в городах улицы, и на улицах здания разных типов.
    * Разные типы зданий каждый ход отдают показатели по 'статистике', такие как благополучие, экология туризм и бюджет.
    * На бюджетные деньги покупаются здания, улицы и города.
    * При недостатке денег в бюджете на новое здание игра заканчивается.
    * Также можно проводить 'Прием граждан' выполняя текстовые квесты и вкладываясь в разные отрасли для регуляции экономики игры
    *
     */
    public static void main(String[] args) {
        Game game = new Game();
        game.mainMenu();
    }
}
