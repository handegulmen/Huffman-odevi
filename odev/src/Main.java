public class Main {

    public static void main(String[] args) {
        int[] histo = new int[]{8,63,73,43,100};
        System.out.println("Codage de Huffman:");
        String[] huffman = huffman(histo);
        for (int i = 0; i < huffman.length; i++) {
            if (histo[i] > 0) {
                System.out.println(i + "] " +huffman[i]);
            }
        }
    }
    public static String[] huffman(int[] histo) {
            String[] codage = new String[histo.length];
            int valeur1;
            int valeur2;
            int index1 = 0;
            int index2 = 0;
            for (int i = 0; i < histo.length; i++) {
                codage[i] = new String();
            }
            do {
                valeur1 = Integer.MAX_VALUE;
                valeur2 = Integer.MAX_VALUE;
                for (int i = 0; i < histo.length; i++) {
                    if (histo[i] > 0) {
                        if (histo[i] < valeur1) {
                            valeur2 = valeur1;
                            valeur1 = histo[index1 = i];
                        } else if (histo[i] < valeur2) {
                            valeur2 = histo[index2 = i];
                        }
                    }
                }
                histo[index1] = 0;
                histo[index2] += valeur1;
                codage[index1] = codage[index1] + "0";
                codage[index2] = codage[index2] + "1";
            }
            while (valeur2 != Integer.MAX_VALUE);
            return codage;
        }
    }