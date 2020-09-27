#include <iostream>
#include <vector>
#include <algorithm>

using std::vector;
using std::cin;
using std::cout;
using std::swap;
using std::pair;
using std::make_pair;

class HeapBuilder {
private:
    vector<int> data_;
    vector< pair<int, int> > swaps_;

    void WriteResponse() const {
        cout << swaps_.size() << "\n";
        for (int i = 0; i < swaps_.size(); ++i) {
            cout << swaps_[i].first << " " << swaps_[i].second << "\n";
        }
    }

    void ReadData() {
        int n;
        cin >> n;
        data_.resize(n);
        for (int i = 0; i < n; ++i)
            cin >> data_[i];
    }

    void GenerateSwaps() {
        swaps_.clear();
        // The following naive implementation just sorts 
        // the given sequence using selection sort algorithm
        // and saves the resulting sequence of swaps.
        // This turns the given array into a heap, 
        // but in the worst case gives a quadratic number of swaps.
        //
        // TODO: replace by a more efficient implementation
        if (data_.size() != data_.size() / 2)
        {
            for (int i = data_.size() / 2; i >= 1; i--)
            {
                shift_down(i);
            }
        }
        else
        {
            if (data_[data_.size() - 1] > data_[data_.size() * 2 - 1])
            {
                swap(data_[data_.size() - 1], data_[data_.size() * 2 - 1]);
                swaps_.push_back(make_pair(data_.size() - 1, data_.size() * 2 - 1));
            }
            for (int i = data_.size() / 2 - 1; i >= 1; i--)
            {
                shift_down(i);
            }
        }
        //this is naive algorithm.
        /*for (int i = 0; i < data_.size(); ++i)
            for (int j = i + 1; j < data_.size(); ++j) {
                if (data_[i] > data_[j]) {
                    swap(data_[i], data_[j]);
                    swaps_.push_back(make_pair(i, j));
                }
            }*/
    }

    void shift_down(int i)
    {
        if (data_[i - 1] > data_[i * 2 - 1])
        {
            swap(data_[i - 1], data_[i * 2 - 1]);
            swaps_.push_back(make_pair(i - 1, i * 2 - 1));
        }
        
        if (data_[i - 1] > data_[i * 2])
        {
            swap(data_[i - 1], data_[i * 2]);
            swaps_.push_back(make_pair(i - 1, i * 2));
        }
    }

public:
    void Solve() {
        ReadData();
        GenerateSwaps();
        WriteResponse();
    }
};

int main() {
    std::ios_base::sync_with_stdio(false);
    HeapBuilder heap_builder;
    heap_builder.Solve();

    return 0;
}
