import {Component, Input, OnInit} from "@angular/core";
import {Copypasta} from "../../../model/copypasta";
import {IStarRatingOnRatingChangeEven} from "angular-star-rating";
import {Comment} from "../../../model/comment";
import {CopypastaService} from "../../../services/copypasta.service";
import {User} from "../../../model/user";
import {Rating} from "../../../model/rating";

@Component({
  selector: 'app-copypasta',
  templateUrl: './copypasta.component.html',
  styleUrls: ['./copypasta.component.css'],
  providers: [CopypastaService]
})
export class CopypastaComponent implements OnInit {

  @Input('copypasta') copypasta: Copypasta;

  avgRating: number;
  myRating: number;
  currentComment: string;

  constructor(private copypastaService: CopypastaService) { }

  ngOnInit() {
    this.getRatings();
  }

  getRatings() {
    this.avgRating = this.copypasta.ratings.map(rating => rating.value).reduce((a, b) => a + b) / this.copypasta.ratings.length;
    this.myRating = 0;
  }

  myRatingValue(): string {
    return this.myRating === 0 ? "?" : this.myRating.toString();
  }

  onRatingChange($event: IStarRatingOnRatingChangeEven) {
    if (this.myRating === 0) {
      const rating = new Rating;
      rating.value = $event.rating;
      rating.author = new User;
      this.copypasta.ratings.push(rating);
      this.copypastaService.addRating(rating, this.copypasta.id);
    }
    this.myRating = $event.rating;
  }

  addComment() {
    const comment = new Comment;
    comment.text = this.currentComment;
    comment.author = new User;
    this.copypasta.comments.push(comment);
    this.copypastaService.addComment(comment, this.copypasta.id);
  }
}
