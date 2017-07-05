import {Component, Input, OnInit} from "@angular/core";
import {Copypasta} from "../../../model/copypasta";
import {IStarRatingOnRatingChangeEven} from "angular-star-rating";
import {Comment} from "../../../model/comment";
import {CopypastaService} from "../../../services/copypasta.service";
import {Rating} from "../../../model/rating";
import {AuthService} from "../../../services/auth.service";

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
    const myRatingStream = this.copypasta.ratings.filter(rating => rating.author === AuthService.getCurrentUsername());
    this.myRating = myRatingStream.length === 0 ? 0 : myRatingStream.map(rating => rating.value).pop();
  }

  myRatingValue(): string {
    return this.myRating === 0 ? "?" : this.myRating.toString();
  }

  onRatingChange($event: IStarRatingOnRatingChangeEven) {
    if (this.myRating === 0) {
      const rating = new Rating;
      rating.value = $event.rating;
      rating.author = AuthService.getCurrentUsername();
      this.copypasta.ratings.push(rating);
      this.copypastaService.addRating(rating, this.copypasta.id);
    }
    this.getRatings();
  }

  addComment() {
    const comment = new Comment;
    comment.text = this.currentComment;
    comment.author = AuthService.getCurrentUsername();
    this.copypasta.comments.push(comment);
    this.copypastaService.addComment(comment, this.copypasta.id);
  }
}
