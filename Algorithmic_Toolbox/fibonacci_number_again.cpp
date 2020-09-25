#include <iostream>
#include <vector>

long long get_fibonacci_huge_naive(long long n, long long m) {
    if (n <= 1)
        return n;

    long long previous = 0;
    long long current = 1;

    for (long long i = 0; i < n - 1; ++i) {
        long long tmp_previous = previous;
        previous = current;
        current = tmp_previous + current;
    }

    return current % m;
}

long long get_fibonacci_huge_fast(long long n, long long m)
{
    if (n <= 1)
        return n;

    std::vector<long long> periodic;
    periodic.push_back(0);
    periodic.push_back(1);

    long long previous = 0;
    long long current = 1;
    long long cell;

    for (int i = 2; i <= n; i++)
    {
        cell = (previous + current) % m;
        
        if (periodic.back() == 0 && cell == 1)
        {
            periodic.pop_back();
            break;
        }

        previous = current;
        current = cell;
        periodic.push_back(current);
    }

    int p_size = periodic.size();

    return periodic[n % p_size];
}

int main() {
    long long n, m;
    std::cin >> n >> m;
    std::cout << get_fibonacci_huge_fast(n, m) << '\n';

    return 0;
}
