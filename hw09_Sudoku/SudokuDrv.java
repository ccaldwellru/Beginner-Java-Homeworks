public class SudokuDrv {
public static void main(String[] args) {
    testCube("123456789234567891345678912456789123567891234678912345789123456891234567912345678");
    testCube("111222333111222333111222333444555666444555666444555666777888999777888999777888999");
    testCube("438291798748392918741234987612348765123987621387651234987612348765123498761234765");
    testCube("123456789456789123789123456234567891567891234891234567345678912678912345912345678");
    testCube("1234567894567891237891 3456234567891567891234891234567345678912678912345912345678");
    testCube("123456789456789123789123456234567891567891294891234567345678312678912345912345678");
    testCube("12 45 7894  789 237 912 4 623 56 8  567 9 2 48 12 45 73 56 83 26 8912 45    4   8");
}

public static void testCube(String contents) {
    SudokuCube cube = new SudokuCube(contents);
    /*
    for (int ii = 1; ii <= 9; ii++) {
        System.out.println("Block " + ii + ":\n"+ cube.getBlockAsString(ii) + "\n\n");
    }
    */
    System.out.println();
    System.out.println(cube.toString());
    for (int ii = 1; ii <= 9; ii++) {
        System.out.println("row " + ii + " correct: " + cube.isRowCorrect(ii));
        System.out.println("      complete: " + cube.isRowComplete(ii));
    }
    for (int ii = 1; ii <= 9; ii++) {
        System.out.println("column " + ii + " correct: " + cube.isColumnCorrect(ii));
        System.out.println("         complete: " + cube.isColumnComplete(ii));
    }
    for (int ii = 1; ii <= 9; ii++) {
        System.out.println("block " + ii + " correct: " + cube.isBlockCorrect(ii));
        System.out.println("         complete: " + cube.isBlockComplete(ii));
    }
    System.out.println("cube complete: " + cube.isCubeComplete());
}
}
