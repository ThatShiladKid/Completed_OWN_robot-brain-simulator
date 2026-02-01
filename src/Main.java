static int x = 0;
static int y = 0;
static String Direction = "Forward";
static int battery = 100;

static void operation(String Option) {
    switch (Direction) {
        case "Forward" -> {
            if (Option.equals("1")) {
                y += 1;
                battery -= 5;
            } else if (Option.equals("2")) {
                y -= 1;
                battery -= 5;
            } else if (Option.equals("3")) {
                Direction = "Left";
                battery -= 2;
            } else if (Option.equals("4")) {
                Direction = "Right";
                battery -= 2;
            } else if (!Option.equals("5")) {
                System.out.println("Please enter a number from 1 to 5.");
            }
        }
        case "Left" -> {
            if (Option.equals("1")) {
                x -= 1;
                battery -= 5;
            } else if (Option.equals("2")) {
                x += 1;
                battery -= 5;
            } else if (Option.equals("3")) {
                Direction = "Backward";
                battery -= 2;
            } else if (Option.equals("4")) {
                Direction = "Forward";
                battery -= 2;
            } else if (!Option.equals("5")) {
                System.out.println("Please enter a number from 1 to 5.");
            }
        }
        case "Backward" -> {
            if (Option.equals("1")) {
                y -= 1;
                battery -= 5;
            } else if (Option.equals("2")) {
                y += 1;
                battery -= 5;
            } else if (Option.equals("3")) {
                Direction = "Right";
                battery -= 2;
            } else if (Option.equals("4")) {
                Direction = "Left";
                battery -= 2;
            } else if (!Option.equals("5")) {
                System.out.println("Please enter a number from 1 to 5.");
            }
        }
        default -> {
            if (Option.equals("1")) {
                x += 1;
                battery -= 5;
            } else if (Option.equals("2")) {
                x -= 1;
                battery -= 5;
            } else if (Option.equals("3")) {
                Direction = "Forward";
                battery -= 2;
            } else if (Option.equals("4")) {
                Direction = "Backward";
                battery -= 2;
            } else if (!Option.equals("5")) {
                System.out.println("Please enter a number from 1 to 5.");
            }
        }
    }
}

void main() {
    System.out.println("Welcome to Robot Brain Simulator!");

    Scanner sc = new Scanner(System.in);

    System.out.println("Enter a number to begin:\n1. Move forward (5%)\n2. Move backward (5%)\n3. Turn left (2%)\n4. Turn right (2%)\n5. Stop\n");
    System.out.println("Your battery is at 100%.");
    String Choice = sc.next();

    while ((!Choice.equals("5")) && battery > 0) {
        operation(Choice);
        System.out.println("Your battery is at " + battery + "%.");
        System.out.println("Enter a number:\n1. Move forward (5%)\n2. Move backward (5%)\n3. Turn left (2%)\n4. Turn right (2%)\n5. Stop\n");
        Choice = sc.next();
    }

    String xString = String.valueOf(Math.abs(x));
    String yString = String.valueOf(Math.abs(y));

    if (x == 0 && y == 0) {
        System.out.println("The robot did not move positions.");
    } else if (x == 0 && y > 0) {
        System.out.println("The robot moved " + yString + " units north.");
    } else if (x == 0) {
        System.out.println("The robot moved " + yString + " units south.");
    } else if (x > 0 && y == 0) {
        System.out.println("The robot moved " + xString + " units east.");
    } else if (x > 0 && y > 0) {
        System.out.println("The robot moved " + yString + " units north and " + xString + " units east.");
    } else if (x > 0) {
        System.out.println("The robot moved " + yString + " units south and " + xString + " units east.");
    } else if (y == 0) {
        System.out.println("The robot moved " + xString + " units west.");
    } else if (y > 0) {
        System.out.println("The robot moved " + yString + " units north and " + xString + " units west.");
    } else {
        System.out.println("The robot moved " + yString + " units south and " + xString + " units west.");
    }
}