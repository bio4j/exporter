//computes the average age from default graph objects
g = TinkerGraphFactory.createTinkerGraph() //default graph
total = 0
for (i in 1..g.vertices.size())
    if(g.v(i).age != null)
        total = total + g.v(i).age

avg = total / g.vertices.size()
println avg 
