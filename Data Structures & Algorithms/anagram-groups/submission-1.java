class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map=new HashMap<>();
        for(String s:strs)
        {
            char[] sarr=s.toCharArray();
            Arrays.sort(sarr);
            String res=new String(sarr);
            if(map.containsKey(res))
            {
                map.get(res).add(s);
            }
            else{
                map.put(res,new ArrayList<>());
                map.get(res).add(s);
            }
        }
        return new ArrayList<>(map.values());
    }
}
