const menu = new Map();

menu.set("name", "Alu Palak");
menu.set(1, "India");
menu.set(2, "USA");

console.log(menu);

menu
  .set("Categories", ["Rice", "Curries", "Breads", "Soups"])
  .set(3, "Australia")
  .set(4, "South Africa");

console.log(menu);
