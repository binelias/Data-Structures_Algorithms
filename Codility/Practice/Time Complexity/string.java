let string_length = my_string.length();
let up = '^';
let down = 'v';
let left = '<';
let right = '>';

//Now count the number of each to determine the count for each
let up_count = 0;
let down_count = 0;
let left_count = 0;
let right_count = 0;
for(let i = 0; i<string_length;i++)
{
    let index = i;
    // Get the specific letacter
    let ch = getletFromString(my_string, index);
    if (ch == up)
    {
        up_count = up_count + 1;
    }
    else if (ch == down)
    {
        down_count = down_count + 1;
    }
    else if (ch == left)
    {
        left_count = left_count + 1;
    }
    else if (ch == right)
    {
        right_count = right_count+1;
    }
    else
    {
        //just do nothing
    }
}
//now determine the maximum in order to know which direction others sholud follow
let[] directions ={up_count,down_count,left_count,right_count};
let maximum_index = 0;
let maximum = 0;
let lowest_sum = 0;
for(let j = 0; j < 4; j++)
{
    if(directions[j]>maximum)
    {
        maximum = directions[j];
        maximum_index = j;
    }
}

//Now add the three lowest
for(let x = 0; x < 4; x++)
{
    if(maximum_index != x)
    {
        lowest_sum = lowest_sum + directions[x];
    }
}
return  lowest_sum;