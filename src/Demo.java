import com.sun.org.apache.bcel.internal.util.Class2HTML;

import java.util.*;

public class Demo {

    public static void main(String[] args) {
        LinkedList<String> placesToVisit= new LinkedList<String>();
    addInOrder(placesToVisit,"Sydney");
    addInOrder(placesToVisit,"New York");
    addInOrder(placesToVisit,"Dallas");
    addInOrder(placesToVisit,"Boston");
    addInOrder(placesToVisit,"San Diego");
    addInOrder(placesToVisit,"Melbourne");
    addInOrder(placesToVisit,"Los Angeles");
    addInOrder(placesToVisit,"Seattle");
    printList(placesToVisit);


    addInOrder(placesToVisit,"Adelaide");
    addInOrder(placesToVisit,"Dallas");
    printList(placesToVisit);

        visit(placesToVisit);
    }


    private static void printList(LinkedList<String> linkedList){
        Iterator<String> i= linkedList.iterator();
        while (i.hasNext()){
            System.out.println("Now visiting "+i.next());
        }

        System.out.println("=======================");
    }

    private static boolean addInOrder(LinkedList<String> linkedList,String newCity){
        ListIterator<String> stringListIterator= linkedList.listIterator();

        while (stringListIterator.hasNext()){
            int comparison= stringListIterator.next().compareTo(newCity);
            if(comparison==0){
                System.out.println(newCity+ " city is already in the list.");
                return false;
            }
            else if(comparison>0){
                stringListIterator.previous();
                stringListIterator.add(newCity);
                return true;
            }
            else if(comparison<0){
                //move on to next city which already has been done on line 39 with next();
            }


        }
        stringListIterator.add(newCity);
        return true;
    }


    private static void visit(LinkedList cities){

        Scanner scanner= new Scanner(System.in);

        boolean quit= false;
        boolean goingForward= true;

        ListIterator<String> listIterator= cities.listIterator();

        if(cities.isEmpty()){
            System.out.println("No cities in the itenerary.");
            return;
        }
        else {
            System.out.println("Now visiting "+listIterator.next());
            printMenu();
        }


        while (!quit){
            int action= scanner.nextInt();
            scanner.nextLine();
            switch (action){
                case 0:
                    System.out.println("Holiday over");
                    quit=true;
                    break;

                case 1:
                    if(!goingForward){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        goingForward=true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println("Now visiting "+listIterator.next());
                    }
                    else {
                        System.out.println("Reached the end of list.");
                        goingForward=false;
                    }
                    break;

                case 2:
                    if(goingForward){
                        if(listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        goingForward=false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("Now visiting "+listIterator.previous());
                        goingForward=true;
                    }
                    else {
                        System.out.println("We are at the start of the list.");
                    }
                    break;
                case 3:
                    printMenu();
                    break;

            }

        }
    }

    private static void printMenu(){
        System.out.println("Available actions:press\n");
        System.out.println("0- to quit\n"+"1- go to next city\n"+"2- go to previous city\n"+"3-print menu option\n");

    }

}
