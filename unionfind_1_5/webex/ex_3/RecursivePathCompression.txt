package unionfind_1_5.webex.ex3;
public int find(int p){
  if(data[p] == p) return p;
  int r = find(data[p]);
  data[p] = r;

  return r;
}
