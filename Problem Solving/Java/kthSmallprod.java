import java.util.*;

class Solution6 {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        List<Long> op=new ArrayList<Long>();
        for(int i=0; i<nums1.length; i++){
            for(int j=0; j<nums2.length; j++){
                long a=nums1[i];
                long b=nums2[j];
                op.add(a*b);
            }
        }
        Collections.sort(op);
        return op.get((int) k-1);
    }
    public static void main(String[] args) {
        int[] nums1={-500,-499,-499,-498,-498,-496,-495,-494,-492,-491,-490,-485,-485,-479,-479,-474,-467,-467,-459,-458,-458,-458,-456,-454,-453,-451,-451,-450,-446,-444,-442,-441,-441,-440,-434,-434,-431,-430,-427,-426,-426,-421,-420,-420,-418,-417,-413,-408,-407,-407,-407,-403,-400,-400,-400,-399,-396,-396,-396,-395,-394,-393,-392,-391,-387,-386,-385,-385,-384,-381,-381,-380,-379,-376,-376,-375,-375,-373,-373,-373,-372,-369,-368,-368,-367,-363,-362,-360,-358,-355,-352,-352,-348,-348,-348,-347,-346,-345,-344,-342,-341,-340,-340,-338,-337,-336,-335,-334,-329,-328,-328,-327,-325,-322,-321,-319,-319,-319,-318,-318,-318,-316,-315,-313,-311,-310,-310,-309,-308,-304,-303,-302,-301,-299,-299,-298,-294,-292,-292,-291,-288,-287,-286,-283,-283,-282,-281,-281,-279,-278,-277,-276,-275,-273,-273,-273,-269,-269,-268,-268,-267,-266,-265,-259,-257,-254,-254,-251,-250,-248,-248,-246,-243,-240,-239,-238,-237,-237,-236,-234,-232,-230,-221,-220,-219,-219,-217,-217,-216,-216,-211,-211,-209,-204,-199,-198,-196,-193,-192,-192,-189,-189,-188,-187,-186,-184,-184,-184,-184,-183,-183,-180,-179,-178,-177,-176,-175,-173,-170,-169,-168,-167,-166,-165,-165,-164,-163,-161,-161,-157,-156,-155,-151,-147,-146,-145,-145,-144,-144,-142,-139,-137,-136,-133,-132,-129,-129,-128,-127,-126,-126,-118,-118,-117,-116,-115,-113,-111,-110,-105,-105,-104,-103,-100,-98,-97,-94,-93,-92,-91,-89,-88,-87,-86,-85,-81,-79,-79,-78,-76,-76,-74,-72,-68,-68,-65,-63,-62,-60,-59,-58,-58,-57,-56,-54,-54,-53,-52,-51,-49,-48,-48,-47,-45,-45,-44,-44,-42,-38,-35,-35,-34,-33,-31,-29,-28,-25,-25,-24,-23,-23,-21,-20,-20,-19,-13,-11,-10,-9,-9,-7,-7,-5,-2,0,1,1,4,4,4,7,8,9,9,9,10,10,11,16,17,17,18,25,28,30,32,35,36,36,38,38,39,39,42,42,44,45,46,46,49,50,52,52,52,52,53,56,59,60,60,62,63,63,64,66,66,67,68,68,69,73,73,74,76,76,80,83,83,85,87,87,90,91,93,93,94,96,99,102,103,103,104,104,104,107,113,115,115,121,121,122,122,122,123,123,125,127,128,129,129,132,135,137,137,138,138,142,142,142,143,148,152,155,156,158,159,160,163,170,171,172,174,174,175,177,178,178,178,181,182,182,187,189,191,195,196,199,199,203,203,207,211,212,213,216,217,221,223,228,229,229,231,231,233,233,233,235,237,237,239,240,246,249,250,251,253,255,257,259,263,264,269,269,273,276,278,279,282,283,283,284,285,286,286,288,289,295,295,296,297,297,298,301,302,303,305,305,306,307,311,312,312,314,314,317,318,321,327,329,329,330,330,332,332,333,334,335,336,338,339,342,346,348,349,349,350,350,351,354,354,355,356,357,358,359,359,362,366,366,368,368,368,368,369,370,370,374,374,376,377,378,378,379,380,380,380,382,382,382,384,386,386,386,390,390,396,397,400,401,401,401,403,403,403,404,405,407,408,409,410,412,416,417,417,419,423,424,425,427,428,432,434,435,437,437,438,439,439,440,442,442,445,445,446,448,449,449,450,450,450,454,456,459,460,462,462,462,464,466,466,467,467,469,471,471,474,474,474,476,480,480,480,481,483,484,484,485,486,486,486,491,494,495,496,496,497};
        int[] nums2={-495,-493,-491,-483,-474,-456,-456,-454,-453,-452,-449,-446,-443,-442,-442,-437,-436,-428,-426,-425,-422,-420,-411,-408,-398,-398,-396,-395,-394,-394,-390,-389,-379,-377,-371,-371,-364,-360,-357,-342,-341,-340,-337,-337,-323,-321,-319,-314,-313,-311,-310,-307,-304,-301,-301,-300,-292,-288,-288,-287,-286,-279,-278,-276,-276,-275,-275,-272,-268,-268,-263,-261,-258,-257,-251,-251,-249,-248,-241,-238,-219,-219,-216,-209,-206,-206,-205,-205,-198,-196,-194,-173,-169,-169,-164,-156,-146,-131,-129,-127,-114,-113,-111,-111,-110,-104,-104,-102,-101,-88,-83,-82,-75,-75,-74,-67,-66,-66,-65,-63,-52,-51,-51,-49,-44,-40,-36,-35,-32,-31,-30,-19,-19,-18,-17,-16,-13,2,3,4,9,10,11,12,12,14,24,28,29,33,35,35,38,44,46,54,56,65,68,70,81,82,82,84,92,92,98,99,100,100,100,119,128,135,137,139,152,159,159,161,165,172,177,178,186,187,190,198,206,206,215,216,222,231,234,240,248,248,252,260,263,273,277,280,284,286,315,317,318,327,329,330,330,344,347,350,350,351,356,357,362,370,377,381,381,383,384,387,390,397,398,404,406,410,415,415,416,417,435,438,442,444,447,452,454,455,455,460,461,465,467,468,470,474,476,477,481,490,-164,-163,-161,-161,-157,-156,-155,-151,-147,-146,-145,-145,-144,-144,-142,-139,-137,-136,-133,-132,-129,-129,-128,-127,-126,-126,-118,-118,-117,-116,-115,-113,-111,-110,-105,-105,-104,-103,-100,-98,-97,-94,-93,-92,-91,-89,-88,-87,-86,-85,-81,-79,-79,-78,-76,-76,-74,-72,-68,-68,-65,-63,-62,-60,-59,-58,-58,-57,-56,-54,-54,-53,-52,-51,-49,-48,-48,-47,-45,-45,-44,-44,-42,-38,-35,-35,-34,-33,-31,-29,-28,-25,-25,-24,-23,-23,-21,-20,-20,-19,-13,-11,-10,-9,-9,-7,-7,-5,-2,0,1,1,4,4,4,7,8,9,9,9,10,10,11,16,17,17,18,25,28,30,32,35,36,36,38,38,39,39,42,42,44,45,46,46,49,50,52,52,52,52,53,56,59,60,60,62,63,63,64,66,66,67,68,68,69,73,73,74,76,76,80,83,83,85,87,87,90,91,93,93,94,96,99,102,103,103,104,104,104,107,113,115,115,121,121,122,122,122,123,123,125,127,128,129,129,132,135,137,137,138,138,142,142,142,143,148,152,155,156,158,159,160,163,170,171,172,174,174,175,177,178,178,178,181,182,182,187,189,191,195,196,199,199,203,203,207,211,212,213,216,217,221,223,228,229,229,231,231,233,233,233,235,237,237,239,240,246,249,250,251,253,255,257,259,263,264,269,269,273,276,278,279,282,283,283,284,285,286,286,288,289,295,295,296,297,297,298,301,302,303,305,305,306,307,311,312,312,314,314,317,318,321,327,329,329,330,330,332,332,333,334,335,336,338,339,342,346,348,349,349,350,350,351,354,354,355,356,357,358,359,359,362,366,366,368,368,368,368,369,370,370,374,374,376,377,378,378,379,380,380,380,382,382,382,384,386,386,386,390,390,396,397,400,401,401,401,403,403,403,404,405,407,408,409,410,412,416,417,417,419,423,424,425,427,428,432,434,435,437,437,438,439,439,440,442,442,445,445,446,448,449,449,450,450,450,454,456,459,460,462,462,462,464,466,466,467,467,469,471,471,474,474,474,476,480,480,480,481,483,484,484,485,486,486,486,491,494,495,496,496,497};
        long k=146748;
        Solution6 obj=new Solution6();
        System.out.println(obj.kthSmallestProduct(nums1, nums2, k));
    }
}