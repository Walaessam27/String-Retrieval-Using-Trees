package algorithmHW2trail2;

import java.util.*;

class nodes {
    Map<Character, nodes> ch;
    boolean ending;
    nodes() {
        ch = new HashMap<>();
        ending = false;}}

class Algotree {
    nodes root;

    Algotree() {root = new nodes();}

    void insert(String s) {
        nodes node = root;
        for (char c : s.toCharArray()) {
            if (!node.ch.containsKey(c)) {
                node.ch.put(c, new nodes());}
            node = node.ch.get(c);}
        node.ending = true;}

    boolean search(String s) {
        nodes node = root;
        for (char c : s.toCharArray()) {
            if (!node.ch.containsKey(c)) {
                return false;}
            node = node.ch.get(c);}
        return node.ending;}

    List<String> startsWith(String s) {
        nodes node = root;
        for (char c : s.toCharArray()) {
            if (!node.ch.containsKey(c)) {
                return new ArrayList<>();}
            node = node.ch.get(c);}
        List<String> res = new ArrayList<>();
        StringBuilder str = new StringBuilder(s);
        dfs(node, str, res);
        return res;}

    void dfs(nodes node, StringBuilder str, List<String> res) {
        if (node.ending) {
            res.add(str.toString());}
        for (char c : node.ch.keySet()) {
            str.append(c);
            dfs(node.ch.get(c), str, res);
            str.deleteCharAt(str.length() - 1);}}

    boolean delete(String s) {return deletemethod(root, s, 0);}

    boolean deletemethod(nodes node, String s, int d) {
        if (node == null) {
            return false;}
        if (d == s.length()) {
            if (!node.ending) {
                return false;}
            node.ending = false;
            return node.ch.isEmpty();}
        char c = s.charAt(d);
        if (!node.ch.containsKey(c)) {
            return false;}
        boolean deletech = deletemethod(node.ch.get(c), s, d + 1);
        if (deletech) {
            node.ch.remove(c);
            return node.ch.isEmpty();}
        return false;}

    String longest() {
        StringBuilder longeststr = new StringBuilder();
        dfsLongest(root, new StringBuilder(), longeststr);
        return longeststr.toString();}

    void dfsLongest(nodes node, StringBuilder str, StringBuilder longeststr) {
        if (node.ending && str.length() > longeststr.length()) {
            longeststr.setLength(0);
            longeststr.append(str);}
        for (char c : node.ch.keySet()) {
            str.append(c);
            dfsLongest(node.ch.get(c), str, longeststr);
            str.deleteCharAt(str.length() - 1);}}}



