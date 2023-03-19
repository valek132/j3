import java.util.ArrayList;
import java.util.Scanner;

public class Program{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        CollectionFigures all = new CollectionFigures();
        programMenu(input, getArrayB());
        input.close();

    }

    public static ArrayList<Figures> getArrayB() {
        return CollectionFigures.allFigure;
    }

    public static void programMenu(Scanner input, ArrayList<Figures> allFigure) {
        System.out.println("\n1. Добавить новую фигуру");
        System.out.println("2. Посчитать периметр у всех фигур");
        System.out.println("3. Посчитать площадь у всех фигур");
        System.out.println("4. Вывода информации о всех периметах, площадях и длиннах окружности всех фигур, где это возможно");
        System.out.println("5. Удаление фигуры");
        System.out.println("6. Изменение фигуры");
        System.out.println("7. сортировки по площади, вывод информации о всех фигурах");
        System.out.print("Введите число: ");
        int choise = input.nextInt();
        System.out.println();
        switch (choise) {
            case 1:
                createNewFigures(input, allFigure);
                programMenu(input, allFigure);
            case 2:
                getAllPerimeter(allFigure);
                programMenu(input, allFigure);
            case 3:
                getAllArea(allFigure);
                programMenu(input, allFigure);
            case 4:
                CollectionFigures.getAllParameters();
                programMenu(input, allFigure);
            case 5:
                CollectionFigures.delleteFigure(input, allFigure);
                programMenu(input, allFigure);
            case 6:
                CollectionFigures.editFigure(input, allFigure);
                programMenu(input, allFigure);
            case 7:
                
                CollectionFigures.showAll();
                programMenu(input, allFigure);

        }

    }

    private static void createNewFigures(Scanner input, ArrayList<Figures> allFigure) {
        System.out.println("1. Создать Треугольник");
        System.out.println("2. Создать Квадрат");
        System.out.println("3. Создать Прямоугольник");
        System.out.println("4. Коздать Круг");
        System.out.println("5. Назад");
        System.out.print("Ваш выбор: ");
        int choise = input.nextInt();
        switch (choise) {
            case 1:
                createTriagle(input, allFigure);
                createNewFigures(input, allFigure);
            case 2:
                createSquare(input, allFigure);
                createNewFigures(input, allFigure);
            case 3:
                createRectangle(input, allFigure);
                createNewFigures(input, allFigure);
            case 4:
                createCircle(input, allFigure);
                createNewFigures(input, allFigure);
            case 5:
                programMenu(input, allFigure);
        }

    }

    private static void createTriagle(Scanner input, ArrayList<Figures> allFigure) {
        System.out.println("\nНазовите фигуру: ");
        String name = input.nextLine();
        System.out.print("Введите сторону a: ");
        Double a = input.nextDouble();
        System.out.print("Введите сторону b: ");
        Double b = input.nextDouble();
        System.out.print("Введите сторону c: ");
        Double c = input.nextDouble();
        allFigure.add(new Triangle(name, a, b, c));

    }

    private static void createSquare(Scanner input, ArrayList<Figures> allFigure) {
        System.out.println("\nНазовите фигуру: ");
        String name = input.nextLine();
        System.out.print("Введите сторону a: ");
        Double a = input.nextDouble();
        allFigure.add(new Square(name, a));

    }

    private static void createRectangle(Scanner input, ArrayList<Figures> allFigure) {
        System.out.println("\nНазовите фигуру: ");
        String name = input.nextLine();
        System.out.print("Введите сторону a: ");
        Double a = input.nextDouble();
        System.out.print("Введите сторону b: ");
        Double b = input.nextDouble();
        allFigure.add(new Rectangle(name, a, b));
    }

    private static void createCircle(Scanner input, ArrayList<Figures> allFigure) {
        System.out.println("\nНазовите фигуру: ");
        String name = input.nextLine();
        System.out.print("Введите радиус: ");
        Double radius = input.nextDouble();
        allFigure.add(new Circle(name, radius));
    }

    private static void getAllArea(ArrayList<Figures> allFigure) {
        Double result = (double) 0;
        for (int i = 0; i < allFigure.size(); i++) {
            result += ((Figures) allFigure.get(i)).getArea();
        }
        System.out.printf("\nПлощадь всех фигур = " + result + ";\n");
    }

    private static void getAllPerimeter(ArrayList<Figures> allFigure) {
        Double result = (double) 0;
        for (Figures figure : allFigure) {
            if (figure instanceof Perimeter) {
                result += (((Polygon) figure).getPerimeter());
            }
        }
        System.out.printf("\nПериметр всех возможных фигур = " + result + ";\n");
    }

}