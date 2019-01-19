function tsp_greedy ( filename )

%*****************************************************************************80
%
%% MAIN is the main program for TSP_GREEDY.
%
%  Licensing:
%
%    This code is distributed under the GNU LGPL license.
%
%  Modified:
%
%    27 October 2018
%
%  Author:
%
%    John Burkardt
%
%  Parameters:
%
%    Input, string FILENAME, the name of the file containing the distance
%    matrix information.  This is an optional input.  If it is not provided,
%    the program will prompt for it.
%
  timestamp ( );
  fprintf ( 1, '\n' );
  fprintf ( 1, 'TSP_GREEDY:\n' );
  fprintf ( 1, '  MATLAB version\n' );
  fprintf ( 1, '  For the traveling salesman problem, find a "greedy"\n' );
  fprintf ( 1, '  solution by choosing a starting city, and then constructing\n' );
  fprintf ( 1, '  the tour by always moving to the nearest unvisited city.' );
%
%  Get the distance table.
%
  if ( nargin < 1 )
    fprintf ( 1, '\n' );
    fprintf ( 1, '  The program needs to load a file containing\n' );
    fprintf ( 1, '  a city-to-city distance matrix D.\n' );  
    filename = input ( '  Enter the file name, in quotes:  ' );
  else
    fprintf ( 1, '\n' );
    fprintf ( 1, '  Distance matrix filename is "%s"\n', filename );
  end

  distance = load ( filename );
%
%  Approve the distance table.
%
  [ m, n ] = size ( distance );

  if ( m ~= n )
    fprintf ( 1, '\n' );
    fprintf ( 1, 'TSP_GREEDY - Fatal error!\n' );
    fprintf ( 1, '  The distance matrix D must be square.\n' );
    fprintf ( 1, '  Your matrix has M = %d, N = %d\n', m, n );
    return
  end

  if ( n < 4 )
    fprintf ( 1, '\n' );
    fprintf ( 1, 'TSP_GREEDY - Fatal error!\n' );
    fprintf ( 1, '  This problem is too small!\n' );
    fprintf ( 1, '  The number of cities N must be at least 4.\n' );
    fprintf ( 1, '  Your matrix has N = %d\n', n );
    return
  end

  v = diag ( distance );
  test = norm ( v );

  if ( 0.0 < test )
    fprintf ( 1, '\n' );
    fprintf ( 1, 'TSP_GREEDY - Fatal error!\n' );
    fprintf ( 1, '  The distance matrix D must have zero diagaonal.\n' );
    fprintf ( 1, '  Your matrix has ||diag(D)|| = %g\n', test );
    return
  end

  test = norm ( distance - distance' );

  if ( 0.0 < test )
    fprintf ( 1, '\n' );
    fprintf ( 1, 'TSP_GREEDY - Fatal error!\n' );
    fprintf ( 1, '  The distance matrix D must be symmetric.\n' );
    fprintf ( 1, '  Your matrix has ||D-D''|| = %g\n', test );
    return
  end
%
%  Print the distance matrix.
%
  fprintf ( 1, '\n' );
  fprintf ( 1, '  The city-to-city distance matrix D:\n' )
  fprintf ( 1, '\n' );

  disp ( distance )
%
%  Initialize the best cost and tour.
%
  cost_best = Inf;
  p_best = randperm ( n );

  for start = 1 : n

    p = path_greedy ( n, distance, start );
    cost = path_cost ( n, distance, p );

    if ( cost < cost_best )
      p_best = p;
      cost_best = cost;
      fprintf ( '  So far, best greedy route starts at city %d: cost = %g\n', start, cost );
    end 

  end
%
%  Report.
%
  fprintf ( 1, '\n' );
  fprintf ( 1, '  The best itinerary found:\n' );
  fprintf ( 1, '\n' );
  fprintf ( 1, '  Step  From  To        Distance\n' );
  fprintf ( 1, '\n' );
  for i1 = 1 : n
    i2 = mod ( i1, n ) + 1;
    fprintf ( 1, '  %4d    %2d  %2d  %14.6g\n', ...
      i2, p_best(i1), p_best(i2), distance ( p_best(i1), p_best(i2) ) );
  end
  fprintf ( 1, '  ----    --  --  --------------\n' );
  fprintf ( 1, '  cost:           %14.6g\n', cost_best );
%
%  Terminate.
%
  fprintf ( 1, '\n' );
  fprintf ( 1, 'TSP_GREEDY\n' );
  fprintf ( 1, '  Normal end of execution.\n' );
  fprintf ( 1, '\n' );
  timestamp ( );

  return
end
function cost = path_cost ( n, distance, p );

%*****************************************************************************80
%
%% PATH_COST evaluates the cost of a round trip.
%
%  Licensing:
%
%    This code is distributed under the GNU LGPL license.
%
%  Modified:
%
%    25 October 2018
%
%  Author:
%
%    John Burkardt
%
%  Parameters:
%
%    Input, integer N, the number of cities.
%
%    Input, real DISTANCE(N,N), the city to city distance table.
%
%    Input, integer P(N), a permutation of 1:N, the route.
%
%    Output, real COST, the cost of the route.
%
  cost = 0.0;
  i1 = n;
  for i2 = 1 : n
    cost = cost + distance ( p(i1), p(i2) );
    i1 = i2;
  end

  return
end
function p = path_greedy ( n, distance, start );

%*****************************************************************************80
%
%% PATH_GREEDY finds a greedy route for a given start.
%
%  Licensing:
%
%    This code is distributed under the GNU LGPL license.
%
%  Modified:
%
%    25 October 2018
%
%  Author:
%
%    John Burkardt
%
%  Parameters:
%
%    Input, integer N, the number of cities.
%
%    Input, real DISTANCE(N,N), the city to city distance table.
%
%    Input, integer START, the starting city.
%
%    Output, integer P(N), a greedy route that starts at START.
%
  p = zeros ( n, 1 );
  p(1) = start;

  d = distance(1:n,1:n);
  d(:,start) = Inf;

  for i = 1 : n
    d(i,i) = Inf;
  end

  from = start;
  for j = 2 : n
    [ ~, to ] = min ( d(from,:) );
    p(j) = to;
    d(:,to) = Inf;
  end
  
  return
end
function timestamp ( )

%*****************************************************************************80
%
%% TIMESTAMP prints the current YMDHMS date as a timestamp.
%
%  Licensing:
%
%    This code is distributed under the GNU LGPL license.
%
%  Modified:
%
%    14 February 2003
%
%  Author:
%
%    John Burkardt
%
  t = now;
  c = datevec ( t );
  s = datestr ( c, 0 );
  fprintf ( 1, '%s\n', s );

  return
end