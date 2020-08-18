console.log(process.argv);

var arr = process.argv;

for(var i=0; i<arr.length;i++){
    console.log(i, arr[i]);
}
console.log(":::::::::::::::::::::");

process.argv.forEach(function(item, index){
    console.log(index, ":", item);
})